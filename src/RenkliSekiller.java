
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
    
    //formun gözükmesi
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
	String a = "þþþþþþþþþþ";
	System.out.println(a.charAt(0));
    	setTitle("Renkli \u015Eekiller");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 526, 395);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	//renkler butonunu, bir renk seçildiðinde ne olacaðýný söylediðimiz actionListener
	renkler.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    
		    secilenRenk = renkler.getSelectedItem().toString();//Seçilen renk
		    c = renk.getRenk(secilenRenk);//c objesine secilen rengi atýyoruz
		    sekilFonksiyon(secilenRenk);//fonksiyonu çalýþtýr
		   
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
		    
		    secilenSekil = sekiller.getSelectedItem().toString();//Seçilen Þekil
		    sekilFonksiyon(secilenRenk);//fonksiyonu çalýtþýr
		
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
     * Eðer secilenRenk ve secilenSekil --- deðilse yani seçim yapýlmýþsa
     * Seçilen þekile göre çizim fonksiyonlarý çaðýrýlýr
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
	    case "Dikdörtgen":{
		dikdörtgen_ciz(g);
		break;
	    }
	    case "Üçgen": {
	
		ucgen_ciz(g);
		break;
	    }
	    case "Elips":{
		elips_ciz(g);
		break;
	    }
	    case "Beþgen":{
		besgen_ciz(g);
		break;
	    }
	    case "Altýgen":{
		altigen_ciz(g);
		break;
	    }
	    default:
		System.out.println("Bir hata oluþtu");
	    }
	}
	
    }
    public void ucgen_ciz(Graphics g) {
	
	g = panel.getGraphics();//grafik çizmek için gerekli
	g.clearRect(0, 0, 310, 310);//daha önceden çizilmiþ bir þekil varsa o alaný temizleyen fonksiyon
	int x[]={0,150,300};//x kordinatlarýmýz
	int y[]={300,0,300};//y kordinatlarýmýz
	g.setColor(c);//rengi deðiþtiren fonksiyon c isimli objemizi parametre olarak giriyoruz
	g.drawPolygon(x,y,3);//bu fonksiyon verilen x y kordinatlarýný birleþtirerek çokgen oluþturmaya yarar
	g.fillPolygon(x,y,3);//bu da çokgenin içini doldurmak için kullanýlan fonksiyon
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
    public void dikdörtgen_ciz(Graphics g) {
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
