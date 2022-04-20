//package recommend;
//
//import my.entity.User;
//import my.mapper.ArticleMapper;
//import my.entity.UserToArticle;
//import my.mapper.UserMapper;
//import my.mapper.UserToArticleMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.relational.core.sql.In;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.util.*;
//
///*
// * 基于用户协同过滤的即时动态推荐算法
// * 度量用户间相似性的方法选用：带修正的余弦相似性
// * */
//
//// TODO 加锁防止并发问题
//@Service
//public class UserBaseCF {
//    @Autowired
//    ArticleMapper articleMapper;
//
//    @Autowired
//    UserMapper userMapper;
//
//    @Autowired
//    UserToArticleMapper userToArticleMapper;
//
//    @PostConstruct
//    public void init() {
//        List<UserToArticle> essayHits = articleMapper.getAllEssayHit();
//
//
//        List<User> users = userMapper.selectList(null);
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (EssayHit essayHit: essayHits) {
//            map.put(essayHit.getEssay_id(), map.getOrDefault(essayHit.getEssay_id(), 0)+ essayHit.getHits());
//        }
//
//        for (User user: users) {
//            addUser(user.getUsername());
//        }
//        for (EssayHit essayHit: essayHits) {
//            updateItemScoreOfUser(essayHit.getUsername(), essayHit.getEssay_id(), 1.0 * essayHit.getHits() / map.get(essayHit.getEssay_id()));
//        }
//    }
//
//    //用户的近邻数
//    private static final int UN = 10;
//
//    /*
//     * 维护用户平均打分
//     * num 打分次数 sum 打分分数和
//     * */
//    private Map<String, Integer> numMap;
//    private Map<String, Double> sumMap;
//    private Map<String, Map<Integer, Double>> scoreMap;
//
//    private double getAverage(String username) {
//        if (numMap.containsKey(username)) {
//            return 1.0 * sumMap.get(username) / numMap.get(username);
//        }
//        return 0;
//    }
//
//    //用户近邻
//    private Map<String, List<Neighbor>> neighborMap;
//
//    public void setNeighbor(Map<String, List<Neighbor>> neighborMap) {
//        this.neighborMap = neighborMap;
//    }
//
//    public Map<String, List<Neighbor>> getNeighbor() {
//        return neighborMap;
//    }
//
//    public List<Neighbor> getNeighbor(String username) {
//        return neighborMap.getOrDefault(username, null);
//    }
//
//
//    //向量自身和
//    private double Sum(Map<Integer, Double> arr) {
//        double sum = 0.0;
//        if (arr != null) {
//            for (Integer key : arr.keySet()) {
//                sum += arr.get(key);
//            }
//        }
//        return sum;
//    }
//
//    //向量点积
//    private double vectorMultiple(Map<Integer, Double> arr1, Map<Integer, Double> arr2) {
//        if (arr1.isEmpty() || arr2.isEmpty()) {
//            return 0;
//        }
//        Set<Integer> keys = new HashSet<>();
//        keys.addAll(arr1.keySet());
//        keys.addAll(arr2.keySet());
//
//        double sum = 0.0;
//        for (Integer key : keys) {
//            sum += arr1.getOrDefault(key, 0.0) * arr2.getOrDefault(key, 0.0);
//        }
//        return sum;
//    }
//
//    //Pearson相似度
//    private double Pearson(Map<Integer, Double> x, Map<Integer, Double> y) {
//        double sumX = Sum(x);
//        double sumY = Sum(y);
//        double sumXX = vectorMultiple(x, x);
//        double sumYY = vectorMultiple(y, y);
//        double sumXY = vectorMultiple(x, y);
//        Set<Integer> keys = new HashSet<>();
//        keys.addAll(x.keySet());
//        keys.addAll(y.keySet());
//        int len = keys.size();
//        double upside = sumXY - sumX * sumY / (len);
//        double downside = Math.sqrt((sumXX - Math.pow(sumX, 2) / len) * (sumYY - Math.pow(sumY, 2) / len));
//        return upside / downside;
//    }
//
//    //从稀疏矩阵中提取向量并处理
//    private Map<Integer, Double> getVectorOfMap(Map<Integer, Double> map, Set<Integer> keys, double filling) {
//        Map<Integer, Double> tmp = new HashMap<>();
//        if (keys == null) {
//            return tmp;
//        }
//        for (Integer key : keys)
//            tmp.put(key, map.getOrDefault(key, filling));
//        return tmp;
//    }
//
//    //求user的近邻，求NofUser数组
//    private void findNeighbor(String username) {
//        Set<Integer> keys = null;
//        if (scoreMap.containsKey(username)) {
//            keys = scoreMap.get(username).keySet();
//        }
//
//        Queue<Neighbor> neighbors = new PriorityQueue<>();
//
//        for (String id : scoreMap.keySet()) {
//            if (Objects.equals(id, username)) continue;
//            Map<Integer, Double> V1 = getVectorOfMap(scoreMap.get(username), keys, getAverage(username));
//            Map<Integer, Double> V2 = getVectorOfMap(scoreMap.get(id), keys, getAverage(id));
//            double sim = Pearson(V1, V2);
//            neighbors.add(new Neighbor(id, sim));
//            if (neighbors.size() > UN) neighbors.remove();
//        }
//
//        List<Neighbor> tmp = new ArrayList<>();
//        while (!neighbors.isEmpty()) {
//            tmp.add(neighbors.peek());
//            neighbors.remove();
//        }
//        neighborMap.put(username, tmp);
//    }
//
//    //根据最近邻居给出预测评分
//    private double predictByNeighbor(String userID, int itemID) {//这里的userID为用户输入，减1后为数组下标！
//        double sum1 = 0;
//        double sum2 = 0;
//
//        for (Neighbor neighbor : neighborMap.get(userID)) {
//            double sim = neighbor.getValue();
//            double nei = getAverage(neighbor.getID());
//            if (scoreMap.get(neighbor.getID()).containsKey(itemID))
//                nei = scoreMap.get(neighbor.getID()).get(itemID);
//            sum1 += sim * (nei - getAverage(userID));
//            sum2 += Math.abs(sim);
//        }
//
//        return getAverage(userID) + sum1 / sum2;
//    }
//
//    //根据最近邻居给出推荐物品
//    public List<Integer> Recommending(String userID, int size) {
//        Queue<Item> items = new PriorityQueue<>();
//        Set<Integer> unique = new HashSet<>();//去重
//
//
//        for (Neighbor neighbor : neighborMap.get(userID)) {
//            for (Integer key : scoreMap.get(neighbor.getID()).keySet()) {
//                if (scoreMap.get(userID).containsKey(key)) continue;
//                if (unique.contains(key)) continue;
//                items.add(new Item(key, predictByNeighbor(userID, key)));
//                unique.add(key);
//                if (items.size() > size) {
//                    unique.remove(items.peek().getID());
//                    items.remove();
//                }
//            }
//        }
//
//        List<Integer> itemList = new ArrayList<>();
//
//        for (int i = 0; i < size; i++) {
//            if (!items.isEmpty()) {
//                itemList.add(items.peek().getID());
//                items.remove();
//            }
//        }
//
//        return itemList;
//    }
//
//    public UserBaseCF() {
//        numMap = new HashMap<>();
//        sumMap = new HashMap<>();
//        scoreMap = new HashMap<>();
//        neighborMap = new HashMap<>();
//    }
//
//    public void addUser(String username) {
//        scoreMap.put(username, new HashMap<>());
//        numMap.put(username, 0);
//        sumMap.put(username, 0.0);
//    }
//
//    public int updateItemScoreOfUser(String UserID, Integer ItemID, double ItemScore) {
//
//        if (!scoreMap.get(UserID).containsKey(ItemID)) {
//            numMap.put(UserID, numMap.get(UserID) + 1);
//            sumMap.put(UserID, sumMap.get(UserID) + ItemScore);
//            scoreMap.get(UserID).put(ItemID, ItemScore);
//        } else {
//            sumMap.put(UserID, sumMap.get(UserID) - scoreMap.get(UserID).get(ItemID));
//            sumMap.put(UserID, sumMap.get(UserID) + ItemScore);
//            scoreMap.get(UserID).replace(ItemID, ItemScore);
//        }
//        Set<String> users = numMap.keySet();
//        for (String user : users) {
//            findNeighbor(user);
//        }
//        return 0;
//    }
//
//    public int updateItemScoreOfUser(String UserID, Map<Integer, Double> ScoreMap) {
//        try {
//            numMap.put(UserID, scoreMap.size());
//            sumMap.put(UserID, 0.0);
//
//
//            for (Integer key : ScoreMap.keySet())
//                sumMap.put(UserID, sumMap.get(UserID) + ScoreMap.get(key));
//            scoreMap.put(UserID, ScoreMap);
//
//            for (String user : numMap.keySet()) {
//                findNeighbor(user);
//            }
//            return 0;
//        } catch (Exception e) {
//            return -1;
//        }
//    }
//}
