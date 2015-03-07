package yan.samux.ikaros.com.savac4k.models;

/**
 * Created by Yonkishum on 06-03-2015.
 */
public class Gestos {

    private String palabra, thumbnailUrl, chinese, pro;

    public Gestos(){

    }

    public Gestos(String word, String thumbnailUrl, String chinese, String pro){
        this.palabra = word;
        this.thumbnailUrl = thumbnailUrl;
        this.chinese = chinese;
        this.pro = pro;
    }

    public String getPalabra(){
        return palabra;
    }

    public void setPalabra(String word){
        this.palabra = word;
    }

    public String getThumbnailUrl(){
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl){
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getChinese(){
        return chinese;
    }

    public void setChinese(String chinese){
        this.chinese = chinese;
    }

    public String getPro(){
        return pro;
    }

    public void setPro(String pro){
        this.pro = pro;
    }
}
