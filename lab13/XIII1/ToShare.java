import java.util.*;
public class ToShare {
    private List<Product> produtos;
    private List<Product> shared;
    public ToShare(){
        this.produtos= new ArrayList<>();
    }

    public boolean add(Product p){
        produtos.add(p);
        return true;
    }
    public void remove(String code){
        int id=0;
        for (Product product:produtos){
            if (product.code().equals(code)){
                produtos.remove(id);
            }
            id+=1;
        }   
    }
    public void remove (Product p){
        produtos.remove(p);
    }
    public boolean share(String code, Client user){
        
    }

}
