
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class RenkliSekiller extends JFrame {

    //gerekli olan degiskenler
    private JPanel contentPane;
    private Graphics g;
    private Color c;
    private Renkler renk = new Renkler();
    private String secilenRenk = "---";
    private String secilenSekil = "---";
    private JComboBox sekiller = new JComboBox();
    private JComboBox renkler = new JComboBox();
    private final JPanel panel = new JPanel();
    
    //formun g�z�kmesi
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    RenkliSekiller frame = new RenkliSekiller();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    public RenkliSekiller() {
	String a = "����������";
	System.out.println(a.charAt(0));
    	setTitle("Renkli \u015Eekiller");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 526, 395);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	//renkler butonunu, bir renk se�ildi�inde ne olaca��n� s�yledi�imiz actionListener
	renkler.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    
		    secilenRenk = renkler.getSelectedItem().toString();//Se�ilen renk
		    c = renk.getRenk(secilenRenk);//c objesine secilen rengi at�yoruz
		    sekilFonksiyon(secilenRenk);//fonksiyonu �al��t�r
		   
		}
	});
	renkler.setBounds(31, 130, 109, 32);
	contentPane.add(renkler);
	renkler.setModel(new DefaultComboBoxModel(new String[] {"---", "K\u0131rm\u0131z\u0131", "Sar\u0131", "Mavi", "Ye\u015Fil", "Pembe", "Turuncu", "Beyaz", "Siyah"}));
	renkler.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	
	sekiller.setBounds(31, 59, 109, 32);
	contentPane.add(sekiller);
	sekiller.setFont(new Font("Tahoma", Font.BOLD, 14));
	sekiller.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    
		    secilenSekil = sekiller.getSelectedItem().toString();//Se�ilen �ekil
		    sekilFonksiyon(secilenRenk);//fonksiyonu �al�t��r
		
		}
	});
	sekiller.setModel(new DefaultComboBoxModel(new String[] {"---", "Kare", "Daire", "Elips", "\u00DC\u00E7gen", "Dikd\u00F6rtgen", "Be\u015Fgen", "Alt\u0131gen"}));
	panel.setBounds(180, 32, 301, 310);
	
	contentPane.add(panel);
	
	JLabel lblNewLabel = new JLabel("\u015Eekiller");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblNewLabel.setBounds(31, 36, 110, 13);
	contentPane.add(lblNewLabel);
	
	JLabel lblRenkler = new JLabel("Renkler");
	lblRenkler.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblRenkler.setBounds(30, 107, 110, 13);
	contentPane.add(lblRenkler);
    }
    
    /*
     * E�er secilenRenk ve secilenSekil --- de�ilse yani se�im yap�lm��sa
     * Se�ilen �ekile g�re �izim fonksiyonlar� �a��r�l�r
     * */
    public void sekilFonksiyon(String secilenRenk) {
     if(!secilenSekil.equals("---") && !secilenRenk.equals("---")) {
	switch (sekiller.getSelectedItem().toString()) {
	    case "Kare": {
		kare_ciz(g);
		break;
	    }
	    case "Daire":{
		
		daire_ciz(g);
		break;
	    }
	    case "Dikd�rtgen":{
		dikd�rtgen_ciz(g);
		break;
	    }
	    case "��gen": {
	
		ucgen_ciz(g);
		break;
	    }
	    case "Elips":{
		elips_ciz(g);
		break;
	    }
	    case "Be�gen":{
		besgen_ciz(g);
		break;
	    }
	    case "Alt�gen":{
		altigen_ciz(g);
		break;
	    }
	    default:
		System.out.println("Bir hata olu�tu");
	    }
	}
	
    }
    public void ucgen_ciz(Graphics g) {
	
	g = panel.getGraphics();//grafik �izmek i�in gerekli
	g.clearRect(0, 0, 310, 310);//daha �nceden �izilmi� bir �ekil varsa o alan� temizleyen fonksiyon
	int x[]={0,150,300};//x kordinatlar�m�z
	int y[]={300,0,300};//y kordinatlar�m�z
	g.setColor(c);//rengi de�i�tiren fonksiyon c isimli objemizi parametre olarak giriyoruz
	g.drawPolygon(x,y,3);//bu fonksiyon verilen x y kordinatlar�n� birle�tirerek �okgen olu�turmaya yarar
	g.fillPolygon(x,y,3);//bu da �okgenin i�ini doldurmak i�in kullan�lan fonksiyon
   }
    public void daire_ciz(Graphics g) {
	g = panel.getGraphics();
	g.clearRect(0, 0, 310, 310);
	g.setColor(c);
	g.fillOval(0,0, 300, 300);
	
    }
    public void kare_ciz(Graphics g) {
	g = panel.getGraphics();
	g.clearRect(0, 0, 320, 320);
	int x[]={0,300,300,0};
	int y[]={0,0,300,300};
	g.setColor(c);
	g.drawPolygon(x,y,4);
	g.fillPolygon(x,y,4);
    }
    public void elips_ciz(Graphics g) {
	
	g = panel.getGraphics();
	g.clearRect(0, 0, 310, 310);
	g.setColor(c);
	g.fillOval(0,50, 300, 175);
    }
    public void dikd�rtgen_ciz(Graphics g) {
	g = panel.getGraphics();
	g.clearRect(0, 0, 310, 310);
	int x[]={75,225,225,75};
	int y[]={0,0,300,300};
	g.setColor(c);
	g.drawPolygon(x,y,4);
	g.fillPolygon(x,y,4);
    }
    public void besgen_ciz(Graphics g)
    {
	g = panel.getGraphics();
	g.clearRect(0, 0, 310, 310);
	int x[]={150,300,240,60,0};
	int y[]={0,125,300,300,125};
	g.setColor(c);
	g.drawPolygon(x,y,5);
	g.fillPolygon(x,y,5);
    }
    public void altigen_ciz(Graphics g) {
	g = panel.getGraphics();
	g.clearRect(0, 0, 310, 310);
	int x[]={0,150,300,300,150,0};
	int y[]={90,0,90,210,300,210};
	g.setColor(c);
	g.drawPolygon(x,y,6);
	g.fillPolygon(x,y,6);
	
    }
}
