package gov.co.acaciasmeta.clases;

public class Item {
	 
    private Integer image;
    private String title;
    
 
    public Item() {
        super();
    }
 
    public Item(String title, Integer image) {
        super();
        this.image = image;
        this.title = title;
 
    }
 
    public Integer getImage() {
        return image;
    }
 
    public void setImage(Integer image) {
        this.image = image;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
}