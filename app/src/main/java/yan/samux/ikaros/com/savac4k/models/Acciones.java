package yan.samux.ikaros.com.savac4k.models;

/**
 * Created by Yonkishum on 03-03-2015.
 */
public class Acciones {

    private String palabra, thumbnailUrl;

    public Acciones(){

    }

    public Acciones(String word, String thumbnailUrl){
        this.palabra = word;
        this.thumbnailUrl = thumbnailUrl;
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

}
