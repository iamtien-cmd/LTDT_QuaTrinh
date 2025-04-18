package vn.iostar.tuan5.ListView;

public class MonHoc {
    private String name;
    private String desc;
    private int pic;

    public MonHoc(String name, String desc, int pic) {
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
    public void setName(String name) { // Thêm phương thức này để cập nhật tên
        this.name = name;
    }
}
