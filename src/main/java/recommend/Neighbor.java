package recommend;

public class Neighbor implements Comparable{
    private String id;//编号
    private double value;//相似度
    Neighbor(String id, double value) {
        this.id=id;
        this.value=value;
    }

    public String getID(){
        return id;
    }

    public double getValue(){
        return value;
    }

    public int compareTo(Object o) {//降序排列
        // TODO Auto-generated method stub
        if(o instanceof Neighbor){
            String ID=((Neighbor) o).id;
            Double VALUE=((Neighbor) o).value;
            return VALUE.compareTo(value);
        }
        else{
            return 2;
        }
    }
}
