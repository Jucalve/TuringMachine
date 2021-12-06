package turing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.lang.StringBuilder;
 
public class Turing extends JPanel{
    
    public int aux=0;
    public static int t=10, lim=200, limra=15, ttl=1000000;
    public char[] cin;
    public int pos, posf;
    public int x=450, y=120, w=45, h=44;
    public char est;
    
    public static void main(String[] args) {
        int ti=t, limaux, caux, i, k6;
        char mov='R';
        boolean prr=true;
        int res;
        StringBuilder st=new StringBuilder();
        String braux=null;
        JFrame v = new JFrame();
        Turing panel = new Turing();
        v.getContentPane().add(panel);
        v.pack();
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        FileWriter ftrut=null;
        try {
            ftrut=new FileWriter("DesInst.txt");
        } catch (IOException ex) {
            Logger.getLogger(Turing.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter bw;
        PrintWriter wr;
        bw = new BufferedWriter(ftrut);        
        wr = new PrintWriter(bw);
        
        res=JOptionPane.showConfirmDialog(null, "Gusta que la cadena se genere de manera aleatoria?");
        if(res==0){
            limaux=(int)(Math.random()*100)%limra+1;
            //System.out.println(""+limaux);
            braux="";
            for(int j=0; j<limaux; j++){
                caux=(int)(Math.random()*100)%2;
                if(caux==0){
                    braux=braux+"1";
                }
                else{
                    braux=braux+"0";
                }
            }
        }
        else if(res==1){
            braux=JOptionPane.showInputDialog("Ingrese la cadena");
        }
        else{
            System.exit(0);
        }
        res=JOptionPane.showConfirmDialog(null, "Desea cambiar el limite de movimientos permitidos?\nDefault: "+panel.lim);
        if(res==0){
            panel.lim=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo tamaño"));
        }
        else if(res==1){
            panel.lim=panel.lim;
        }
        else{
            System.exit(0);
        }
        if(braux==null) System.exit(0);
        
        st.append("B");
        st.append(braux);
        st.append("B");
        braux=st.toString();
        //st.append("bruh");
        //System.out.println(st.toString());
        panel.cin=braux.toCharArray();
        panel.pos=1*panel.w;
        panel.posf=1*panel.w;
        panel.est='q';
        //System.out.println(String.valueOf(panel.cin));
        //System.out.println("|-estado-+--Mov--+---------cinta---------|");
        wr.append("|-estado-+--Mov--+---------cinta---------|");
        wr.println();
        v.setVisible(true);
        do{
            try {
                //if(panel.pos/panel.w>0){
                        braux="(    "+panel.est+"   |   "+mov+"   |";
                        st=new StringBuilder();
                        st.append(braux);
                        i=1;
                        if(panel.pos/panel.w==0){
                            st.append("[B]");
                        }
                        else
                            st.append(" ");
                        while(panel.cin[i]!='B'){
                            k6=(panel.pos/panel.w);
                            if(i==k6){
                                st.append('[');
                                st.append(""+panel.cin[i]);
                                st.append("]");
                            }
                            else
                                st.append(""+panel.cin[i]);
                            i++;
                        }
                        if(i==panel.pos/panel.w){
                            st.append("[B]");
                        }
                        st.append(" )");
                        wr.append(st.toString());
                        wr.println();
                        //System.out.println(st.toString());
                    /**/
                    //else System.out.println("("+panel.cin[panel.pos/panel.w]+", "+panel.est+", "+mov+")");
                Thread.sleep(t);
                if(panel.est=='q'){
                    if(panel.cin[panel.pos/panel.w]=='0'){
                        panel.cin[panel.pos/panel.w]='0';
                        panel.est='q';
                        panel.posf=panel.pos+panel.w;
                        mov='R';
                    }
                    else if(panel.cin[panel.pos/panel.w]=='1'){
                        panel.posf=panel.pos+panel.w;
                        panel.est='p';
                        mov='R';
                    }
                    else if(panel.cin[panel.pos/panel.w]=='B'){
                        t=ti/2;
                        panel.posf=panel.pos-panel.w;
                        panel.est='f';
                        mov='L';
                        panel.cin[panel.pos/panel.w]='0';
                        braux=String.valueOf(panel.cin);
                        st=new StringBuilder();
                        st.append(braux);
                        st.append("B");
                        braux=st.toString();
                        panel.cin=braux.toCharArray();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error!\nDato no valido, comenzando autodestruccion\n");
                        Thread.sleep(2000);
                        System.exit(0);
                    }
                }
                else if(panel.est=='p'){
                    if(panel.cin[panel.pos/panel.w]=='0'){
                        panel.cin[panel.pos/panel.w]='1';
                        panel.est='q';
                        panel.posf=panel.pos+panel.w;
                        mov='R';
                    }
                    else if(panel.cin[panel.pos/panel.w]=='1'){
                        panel.cin[panel.pos/panel.w]='1';
                        panel.est='r';
                        panel.posf=panel.pos+panel.w;
                        mov='R';
                    }
                    else if(panel.cin[panel.pos/panel.w]=='B'){
                        prr=false;
                        /*
                        panel.cin[panel.pos/panel.w]=' ';
                        panel.est=' ';
                        panel.posf=panel.pos+panel.w;
                        mov=' ';
                        */
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error!\nDato no valido, comenzando autodestruccion\n");
                        Thread.sleep(2000);
                        System.exit(0);
                    }
                }
                else if(panel.est=='r'){
                    if(panel.cin[panel.pos/panel.w]=='0'){
                        panel.cin[panel.pos/panel.w]='1';
                        panel.est='q';
                        panel.posf=panel.pos+panel.w;
                        mov='R';
                    }
                    else if(panel.cin[panel.pos/panel.w]=='1'){
                        panel.cin[panel.pos/panel.w]='0';
                        panel.est='r';
                        panel.posf=panel.pos+panel.w;
                        mov='R';
                    }
                    else if(panel.cin[panel.pos/panel.w]=='B'){
                        prr=false;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error!\nDato no valido, comenzando autodestruccion\n");
                        Thread.sleep(2000);
                        System.exit(0);
                    }
                }
                else if(panel.est=='f'){
                    t=ti/2;
                    if(panel.cin[panel.pos/panel.w]=='0'){
                        panel.cin[panel.pos/panel.w]='0';
                        panel.est='f';
                        panel.posf=panel.pos-panel.w;
                        mov='L';
                    }
                    else if(panel.cin[panel.pos/panel.w]=='1'){
                        panel.cin[panel.pos/panel.w]='1';
                        panel.est='f';
                        panel.posf=panel.pos-panel.w;
                        mov='L';
                    }
                    else if(panel.cin[panel.pos/panel.w]=='B'){
                        t=ti;
                        panel.cin[panel.pos/panel.w]='0';
                        panel.est='q';
                        panel.x=panel.x-panel.w;
                        panel.posf=panel.w;
                        mov='R';
                        panel.cin[panel.pos/panel.w]='0';
                        panel.pos=panel.w;
                        braux=String.valueOf(panel.cin);
                        st=new StringBuilder();
                        st.append("B");
                        st.append(braux);
                        braux=st.toString();
                        panel.cin=braux.toCharArray();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error!\nDato no valido, comenzando autodestruccion\n");
                        Thread.sleep(2000);
                        System.exit(0);
                    }
                }
                
                while(panel.pos!=panel.posf){
                    if(panel.posf>panel.pos) panel.pos++;
                    else                     panel.pos--;
                    panel.repaint();
                    Thread.sleep(t);
                }
                if(!prr){
                    st=new StringBuilder();
                    st.append("(    "+panel.est+"   |   X   | ");
                    i=1;
                    while(panel.cin[i]!='B'){
                        st.append(panel.cin[i]);
                        i++;
                    }
                    if(i==panel.pos/panel.w){
                        st.append("[B]");
                    }
                    st.append(" )");
                    //System.out.println(st.toString());
                    wr.append(st.toString());
                    wr.println();
                }
                Thread.sleep(t);
            } catch (InterruptedException ex) {
                Logger.getLogger(Turing.class.getName()).log(Level.SEVERE, null, ex);
            }
            panel.aux++;
        }while(panel.aux<=lim && prr);
        //System.out.println("|-estado-+--Mov--+---------cinta---------|");
        wr.append("|-estado-+--Mov--+---------cinta---------|");
        wr.println();
        wr.close();
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Turing.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Thread.sleep(ttl);
            System.exit(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(Turing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void paint(Graphics g){
        super.paint(g);
        int consx=20, consx2=w, consy=25, consy2=80, m=1;
        int i=1;
        Color co=new Color(205, 220, 205);
        Color ca= new Color(215, 210, 210);
        
        for(int rojo=0; rojo< this.getHeight(); rojo++){
            Color col=new Color(50, 50, (255-(rojo*m))%256);
            if(rojo==255) m=-1;
            if(rojo==0) m=1;
            g.setColor (col);
            g.drawLine (0, rojo, this.getWidth(), rojo);
        }
        /*
        for (int rojo = 0 ; rojo < this.getHeight() ; rojo++)
        {
            Color col;
            if(rojo%256<180) col = new Color (255-rojo%180, 30, 10);
            else col = new Color ((255-180)+rojo%180, 30, 10);
            //g.setColor();
            g.setColor (col);
            g.drawLine (0, fila, this.getWidth(), fila);
            fila++;
            
        }
        */
        
        g.setColor(co);
        g.fillRect(x, y, w, h);
        g.setColor(Color.black);
        g.drawRect(x, y, w, h);
        g.drawString(""+cin[0], x+consx, y+consy);
        //System.out.println(cin[0]+" / 0");
        while(cin[i]!='B'){
            g.setColor(co);
            g.fillRect(x+(i*consx2), y, w, h);
            g.setColor(Color.black);
            g.drawRect(x+(i*consx2), y, w, h);
            g.drawString(""+cin[i], x+consx+(i*consx2), y+consy);
            //System.out.println(cin[i]+" / "+i);
            i++;
        }
        g.setColor(co);
        g.fillRect(x+(i*consx2), y, w, h);
        g.setColor(Color.black);
        g.drawRect(x+(i*consx2), y, w, h);
        g.drawString(""+cin[i], x+consx+(i*consx2), y+consy);
        //System.out.println(cin[i]+" / "+i);/**/
        /*******************************cabeza******************************************/
        //while(pos!=posf)
        if(est=='f') ca= new Color(225, 205, 205);
        g.setColor(ca);
        g.fillRect(x+pos, y-consy2, w, h);
        g.setColor(Color.black);
        g.drawRect(x+pos, y-consy2, w, h);
        g.fillRect(x+pos+w/2-2, y-consy2+45, 10, 25);
        g.drawString(""+est, x+consx+pos, y-consy2/2-12);
        /*******************************cabeza******************************************/
        g.drawString("Numero de movimientos: "+aux, 1100, y+100);
        g.drawString("Maximo: "+lim, 1100, y+113);
    }
    
    public Dimension getPreferredSize()
    {
        return new Dimension(1400, 250);
    }
    
}
