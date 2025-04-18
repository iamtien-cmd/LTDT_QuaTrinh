package vn.iostar.tuan5.GridView;

public class MonHocGridView
{
    private String name;
    private String desc;
    private int pic;

    public MonHocGridView(String name, String desc, int pic) {
        this.name = name;
        this.desc = desc;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getPic() {
        return pic;
    }
    public void setName(String name) {
        this.name = name;
    }

}
