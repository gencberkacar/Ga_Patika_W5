import com.sun.source.tree.Tree;

import java.util.TreeSet;

public class Brand{
    private int id;
    private String name;

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }



    public static void BrandList(){
        TreeSet<Brand> brandTreeSet = new TreeSet<>(new BrandIDComparator());

        {
            brandTreeSet.add(new Brand(1,"- Apple\n"));
            brandTreeSet.add(new Brand(2,"- Samsung\n"));
            brandTreeSet.add(new Brand(3,"- Lenovo\n"));
            brandTreeSet.add(new Brand(4,"- Huawei\n"));
            brandTreeSet.add(new Brand(5,"- Casper\n"));
            brandTreeSet.add(new Brand(6,"- Asus\n"));
            brandTreeSet.add(new Brand(7,"- HP\n"));
            brandTreeSet.add(new Brand(8,"- Xiaomi\n\n"));
            brandTreeSet.add(new Brand(9,"- Monster\n"));


            for (Brand i: brandTreeSet) {

                System.out.format(i.getName());
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}