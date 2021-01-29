import java.awt.Color;
/*
 * renkler combobox'unda se�ilen stringe g�re 
 * color objesini de�i�tirece�iz ve kullanaca��z
 * */
public class Renkler {
 
    Color renk;
 
    public Color getRenk(String renk) {
	
	
	switch (renk) {
	case "K�rm�z�": {
	    this.renk = Color.red;
	    break;
	}
	case "Sar�": {
	    this.renk = Color.yellow;
	    break;
	}
	case "Mavi": {
	    this.renk = Color.blue;
	    break;
	}
	case "Ye�il": {
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
