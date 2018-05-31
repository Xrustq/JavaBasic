package EduCenter.entity;

public class Course {
    private String name;
    private int durability;

    public Course(String name, int durability) {

        this.name = name;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", durability=" + durability +
                '}';
    }
}
