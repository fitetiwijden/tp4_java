package techStoree;
import java.util.ArrayList;

public class Stock {

    private ArrayList<Element> articleList;
    public Stock() {
        articleList = new ArrayList<Element>();
    }
    public Stock(ArrayList<Element> liste) {
        articleList = liste;
    }
    public Stock(ArrayList<Integer> id,ArrayList<String> noms,ArrayList<String> reference,ArrayList<Double> prix, ArrayList<Long> quantites) {

        articleList = new ArrayList<Element>();

        for (int i = 0; i < noms.size(); i++) {
            Element e = new Element(id.get(i),noms.get(i),reference.get(i),prix.get(i),quantites.get(i));
            articleList.add(e);
        }
    }

    public ArrayList<Element> getArticleList() {
        return articleList;
    }

    public int getArticleNb() {
        return articleList.size();
    }

    public void setArticleList(ArrayList<Element> liste) {
        articleList = liste;
    }

    public void ajouterArticle(Element e, long quantite) {
        e.setQuantite(quantite);
        articleList.add(e);
    }
    
    public void ajouterArticle(int id,String nom,String reference, double prix, long quantite) {

        Element e = new Element(id,nom,reference, prix, quantite);

        articleList.add(e);
    }
    public Element trouverArticle(String reference) {

        for (Element e : articleList) {

            if (e.equals(reference)) {
                return e;
            }
        }

        return null;
    }
    public void modifierArticle(int id,String reference, String nom,double prix, long quantite) {

        Element e = trouverArticle(reference);

        if (e != null) {
        	Article article =new Article(id,nom,reference,prix);
            e.setArticle(article);
            e.setQuantite(quantite);
        }
    }
    public void supprimerArticle(String reference) {

        Element e = trouverArticle(reference);

        if (e != null) {
            articleList.remove(e);
        }
    }
    public void incrementerQuantiteArticle(String reference, long qte) {

        Element e = trouverArticle(reference);

        if (e != null) {
            e.setQuantite(e.getQuantite() + qte);
        }
    }

    public void decrementerQuantiteArticle(String reference, long qte) {

        Element e = trouverArticle(reference);

        if (e != null) {
            e.setQuantite(e.getQuantite() - qte);
        }
    }
	@Override
	public String toString() {
		return "Stock [articleList=" + articleList + "]";
	}
}