package fit.iuh.thang.xmlbased;

public class Student {
    private Long id;
    private String name;
    private _Class class_;

    public Student() {
    }

    public Student(Long id, String name, _Class class_) {
        this.id = id;
        this.name = name;
        this.class_ = class_;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public _Class getClass_() {
        return class_;
    }

    public void setClass_(_Class class_) {
        this.class_ = class_;
    }
}
