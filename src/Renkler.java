import java.awt.Color;
/*
 * renkler combobox'unda seçilen stringe göre 
 * color objesini deðiþtireceðiz ve kullanacaðýz
 * */
public class Renkler {
 
    Color renk;
 
    public Color getRenk(String renk) {
	
	
	switch (renk) {
	case "Kýrmýzý": {
	    this.renk = Color.red;
	    break;
	}
	case "Sarý": {
	    this.renk = Color.yellow;
	    break;
	}
	case "Mavi": {
	    this.renk = Color.blue;
	    break;
	}
	case "Yeþil": {
	    this.renk = Color.green;
	    break;
	}
	
	case "Pembe": {
	    this.renk = Color.pink;
	    break;
	}
	case "Turuncu": {
	    this.renk = Color.orange;
	    break;
	}
	case "Siyah": {
	    this.renk = Color.black;
	    break;
	}
	case "Beyaz": {
	    this.renk = Color.white;
	    break;
	}
	default:
	   return null;
	}
	
	return this.renk;
	
    }
    
}
