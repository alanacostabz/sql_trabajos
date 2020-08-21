
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RandomPlayer {
    public String campo;
    
    public RandomPlayer(String campo){
        this.campo = campo;
    }
    
    public long Escribir(Player p) throws FileNotFoundException{
        RandomAccessFile salida = null;
        long bytes = 0;
        byte buffer[] = null;
        
        try{
            salida = new RandomAccessFile(campo, "rw");
            bytes = salida.length();
            salida.seek(bytes);
            
            salida.writeInt(p.getSalary());
            
            buffer = p.getFirstName().getBytes();
            salida.write(buffer);
            
            buffer = p.getLastName().getBytes();
            salida.write(buffer);
            
            buffer = p.getBorn().getBytes();
            salida.write(buffer);
            
            buffer = p.getCity().getBytes();
            salida.write(buffer);
            
            buffer = p.getPrst().getBytes();
            salida.write(buffer);
            
            buffer = p.getCntry().getBytes();
            salida.write(buffer);
            
            buffer = p.getNat().getBytes();
            salida.write(buffer);
            
            buffer = p.getPosition().getBytes();
            salida.write(buffer);
            
            buffer = p.getTeam().getBytes();
            salida.write(buffer);
            
            salida.writeShort(p.getHt());
            salida.writeShort(p.getWt());
            salida.writeShort(p.getDftyr());
            salida.writeShort(p.getDftrd());
            salida.writeShort(p.getOvrl());
            salida.writeShort(p.getHand());
            
            salida.close();
            
        }catch (FileNotFoundException ex) {
            Logger.getLogger(RandomPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RandomPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bytes;
    }
    
    public Player Leer(long pos) throws IOException{
        RandomAccessFile salida = null;
        long bytes = 0;
        byte buffer[] = null;
        Player p = null;
        
        try{
         salida.seek(pos);
         
         int salary = salida.readInt();
         
         byte[] firstNameBytes = new byte[20];
         salida.read(firstNameBytes);
         
         byte[] lastNameBytes  = new byte[20];
         salida.read(lastNameBytes);
         
         byte[] bornBytes = new byte[8];
         salida.read(bornBytes);
         
         byte[] cityBytes = new byte[30];
         salida.read(cityBytes);
         
         byte[] prStBytes = new byte[3];
         salida.read(prStBytes);
         
         byte[] cntryBytes = new byte[3];
         salida.read(cntryBytes);
         
         byte[] natBytes = new byte[3];
         salida.read(natBytes);
         
         byte[] postionBytes = new byte[10];
         salida.read(postionBytes);
         
         byte[] teamBytes = new byte[15];
         salida.read(teamBytes);
         
         short ht = salida.readShort();
         short wt = salida.readShort();
         short dftyr = salida.readShort();
         short dftrd = salida.readShort();
         short ovrl = salida.readShort();
         short gp = salida.readShort();
         
         char hand = salida.readChar();
         
         Player x = new Player (salary, new String(firstNameBytes), new String(lastNameBytes), new String(bornBytes), new String(cityBytes),
                    new String(prStBytes), new String(cntryBytes), new String(natBytes), new String(postionBytes), new String(teamBytes),
                    ht, wt, dftyr, dftrd, ovrl, gp, hand);
         
        }catch (FileNotFoundException ex) {
            Logger.getLogger(RandomPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RandomPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
}
