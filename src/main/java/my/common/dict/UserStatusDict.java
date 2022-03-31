package my.common.dict;

/**
 * 用户状态
 *
 * @author chinatower
 */
public enum UserStatusDict
{
    OK("0", "正常"),
    DISABLE("1", "停用"),
    DELETED("2", "删除");

    private final String code;
    private final String desc;

    UserStatusDict(String code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }

    public String getCode()
    {
        return code;
    }

    public String getDesc()
    {
        return desc;
    }
}