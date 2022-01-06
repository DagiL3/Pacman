import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class  Game {
	
    Bord[][] borde;
    public int mykeybord;
	private static int numberPacgammes;
	private Personage_pacman pacman;
	public Personage_fantome[] MyFantome;
	long Timer1_Start;
	long Timer1_End;
	long Timer2_Start;
	long Timer2_End;
	
	private Construction grille;
	private Personage_fantome fantome;
	private IStatePacman state;
	private IStatePacman stateSuper;
	private IStatePacman stateInvisible;
	private IStatePacman stateNormal;
		
		Direction status =Direction.LEFT;
		Direction status2 =Direction.LEFT;
		Direction status3=Direction.LEFT;
		Direction status4=Direction.LEFT;
		Direction choisi=Direction.LEFT; 
		
		 List<Direction> direction=new ArrayList<>();
		 List<Direction> direction1=new ArrayList<>();
		 List<Direction> transition=new ArrayList<>();
		 List<Direction> direction2=new ArrayList<>();
		 
		private List<Integer> colors =new ArrayList<>();
		public int[] posxCenterFantom= {1,2,1,2};
		public int[] posyCenterFantom= {4,4,5,5};
	    Direction StatusPacman=Direction.RIGHT;
		 int index=0 ;
			
		private void createListRandom() { 		
			direction.add(Direction.DOWN);
			direction.add(Direction.LEFT);
			direction.add(Direction.RIGHT);
			direction.add(Direction.UP);
			
			direction1.add(Direction.DOWN);
			direction1.add(Direction.LEFT);
			direction1.add(Direction.RIGHT);
			direction1.add(Direction.UP);			
		}
		
		public	void Mycolors() {
			colors.add(1);
			colors.add(2);colors.add(3);colors.add(4);
		}
		
		public Game(){
            this.grille=new Construction(this);
			this.borde= grille.getBorde();
			this.pacman=grille.getPacman();
			this.MyFantome=grille.getMyFantome();
			this.numberPacgammes=grille.getNumberPacgammes();
			this.stateNormal=new StateNormal(this);
			this.stateSuper=new StateSuperPacman(this);
			this.stateInvisible=new StateInvisible(this);
			this.state=stateNormal;
			
			
			Mycolors();
			createListRandom();
		}
		
		public void verifyTimingState(){
			if(Timer1_Start>=Timer1_End || Timer1_Start>=Timer1_End ) {
				 setState(stateNormal);
			}
		}
		
		public void addPoints(MyPacgomme p){
			if(p==null)return;
			if(p.getPacgome()==null)return;
			 switch(p.getPacgome()){
			 
			 case BLEU:
			    pacman.setPoint(100);
			    //setColor(1);
			    break;
			 case ORANGE:
				  pacman.setPoint(500);
				  initalizeColorBlue();
				    pacman.setColor(8);//orenge
				    Timer1_Start=System.currentTimeMillis();
				    Timer1_End=Timer1_Start+1000;
				    setState(stateSuper);
				    break;
			 case VIOLET:
				 pacman.setPoint(300);
				 initalizeColor();
				 pacman.setColor(7);//7:pale yellow
				 Timer2_Start=System.currentTimeMillis();
				 Timer2_End=Timer2_Start+1000;
				 setState(stateInvisible);
				    break;
			
			 case VERT:
				  pacman.setPoint(1000);
		             //setcolor()//verte
				    break;
		   }
			
		}	
		
		public Bord getCell(int posX,int posY){
			return borde[posX][posY];
		}
		/*
		 * copie b to the positin (posx,posy) 
		 * if b is pacgomme then (x,y) become Empty
		 * if b is fantome then (x,y) become famtom
		 * */
		public void setCellNull(int posX,int posY,Bord b){
			if(b.getType()==Element.OBSTACLE)return;
			if(b.getType()==Element.PACGOMME||b.getType()==Element.EMPTY) {
				borde[posX][posY].setType(Element.EMPTY);
			}else if(b.getType()==Element.FANTOME){
				borde[posX][posY].setType(Element.FANTOME);
				borde[posX][posY].setFantom1(b.getFantom1());
			}   
		}
		/* copie pacman to the positin (posx,posy) 
		 **/
 
		public void setCell(int posX,int posY,Personage_pacman pacman){
			borde[posX][posY].setType((Element) pacman.getType());
			borde[posX][posY].setPacman(pacman);
		}
		
		/*copie b to the positin (posx,posy) 
		 * if b is pacgomme then (x,y) become pacgomme
		 * if b is fantome then (x,y) become famtom
		 * */
		public void  setCellNullF(int posX,int posY, Bord b){
			if(b.getType()==Element.OBSTACLE)return;
			if(b.getType()==Element.PACGOMME||b.getType()==Element.EMPTY) {
				borde[posX][posY].setType(b.getType());	
				borde[posX][posY].setPacgome(b.getMyPacgome());
				// borde[posX][posY].getMyPacgome().setPosX(posX);
			}
			else if(b.getType()==Element.PACMAN) {
            	 borde[posX][posY].setType(Element.PACMAN);
            	 borde[posX][posY].setPacman(b.getPacman());
            	 //borde[posX][posY].getPacman().setVie();
             }
			else if(b.getType()==Element.FANTOME){
				borde[posX][posY].setType(Element.FANTOME);
				borde[posX][posY].setFantom1(b.getFantom1());
				borde[posX][posY].getFantom1().setColor(b.getFantom1().getColor());
			}
		}
		  
		/*copie fantome to the positin (posx,posy)*/
		public void setCellF(int posX,int posY,Personage_fantome fantome){
			//borde[posX][posY].setType(Element.EMPTY);
			borde[posX][posY].setType((Element)fantome.getType());
			borde[posX][posY].setFantom1(fantome);
			borde[posX][posY].getFantom1().setColor(fantome.getColor());
		}
		
		Direction getRandomp(){
			index = (int)(Math.random() * direction1.size());
			return direction1.get(index);
		}

		/*To get Random value of enum direction because fantomes move randomly*/
		 Direction getRandom(){
			/* return  Direction.values()[(int) (Math.random() * Direction.values().length)];*/
			if(!(direction.isEmpty())){
				index = (int)(Math.random() * direction.size());
				choisi=direction.get(index);
				direction.remove(choisi);
				transition.add(choisi);
				if((direction.isEmpty())){
					for(int i=0;i<transition.size();i++){
						Direction dir=transition.get(i);
						direction2.add(dir);
						transition.remove(dir);
					}    	
				}
			}   
			else {	   
				index = (int)(Math.random() * direction2.size());
				choisi=direction2.get(index);
				direction2.remove(choisi);
				transition.add(choisi);
				if((direction2.isEmpty())){
					for(int i=0;i<transition.size();i++) {
						Direction dir=transition.get(i);
						direction.add(dir);
						transition.remove(dir);
					}		   
				}       
			}
			return choisi;
		}
 			
		public void moveFantome(){	
			state.moveFantome();
		}
			 
		public Boolean afficheBord(){
		  for(int i=0;i<borde.length;i++) {
			  for(int j=0;j<borde[i].length;j++) {
				  switch(borde[i][j].getType())
				  {
				  case PACMAN:
					  //System.out.print(borde[i][j].getType());
					  System.out.print(" PACMAN ");
					  break;
				  case PACGOMME:   				
					  System.out.print(borde[i][j].getMyPacgome()/*.getPacgome()+" "*/);
					  //System.out.print(" ");
					  break;   			
				  case OBSTACLE:			
					  //System.out.print(borde[i][j].getType());
					  System.out.print(" OBSTACLE ");
					  break;  	
				  case EMPTY:    				
					  //System.out.print(borde[i][j].getType());
					  System.out.print(" EMPTY ");
					  break;
				  case FANTOME:    				
					  //System.out.print(borde[i][j].getType());
					  System.out.print(" FANTOME ");
					  break;	
    			}
			  } 		 		
			  System.out.println();
		  } 
		  System.out.println();
		  return true;
	  }
       
		/*le pacman mange un pacgomme orange les fantome
         vonent au centre et change leur color en blue 
        * @return 
        * **/	
		public  void FantomeToCentre(int i,int fx,int fy){
				int x=posxCenterFantom[i];
				int y=posyCenterFantom[i];

				Bord rec_avanve=borde[x][y]; 
				Bord fantome=getCell(fx,fy);
				if(rec_avanve.getType()==Element.FANTOME) {
					for(int k=0;k<4;k++) {
						if(rec_avanve.getType()!=Element.FANTOME) {
							i=k;
							break;
						}
					}
					 x=posxCenterFantom[i];
					 y=posyCenterFantom[i];

					 rec_avanve=borde[x][y]; 
				}
			    if(rec_avanve.getType()==Element.PACGOMME){
					rec_avanve.getMyPacgome().setPosX(fx); rec_avanve.getMyPacgome().setPosY(fy);
					setCellNullF(fx,fy,rec_avanve);
				}else if(rec_avanve.getType()==Element.PACMAN){
					pacman=rec_avanve.getPacman();
					System.out.println("center: "+pacman.getPosX());
					setCell(fx,fy,pacman);
					pacman.setPosX(fx);	pacman.setPosY(fy);
				}else if(rec_avanve.getType()==Element.EMPTY){
					setCellNullF(fx,fy,rec_avanve);
					setCellF(x,y,fantome.getFantom1()); 
				}else if(rec_avanve.getType()==Element.FANTOME){
					/*rec_avanve.getFantom1().setPosX(fx); rec_avanve.getFantom1().setPosY(fy);
					  setCellF(fx,fy,rec_avanve.getFantom1());*/
					return;
					}
				 
			    setCellF(x,y,fantome.getFantom1()); 
			    fantome.getFantom1().setPosX(x);
				fantome.getFantom1().setPosY(y);
		}
        
		public void movePacman(){
			 state.movePacman();
		}
		
		/*pour initinalize le couleur de les fantoms de blue au leur color d'origine */
		public void initalizeColor(){
		  for(int i=1;i<=4;i++){
			  MyFantome[i-1].setColor(i);
		  }
	  }
	
		/*pour initinalize le couleur de les fantoms de blue au leur color d'origine */
		public void initalizeColorBlue(){
		  for(int i=0;i<4;i++){
			  MyFantome[i].setColor(11);
		  }
	  }

		public void afficheStatus(){
		  if(pacman.getVie()==0) {
			  JOptionPane.showMessageDialog(null, "Game Over ): ", " Game Status ",
					  JOptionPane.INFORMATION_MESSAGE);		  
		  }else if(pacman.getVie()>0&&getNumberPacgammes()<=0) {
			  JOptionPane.showMessageDialog(null, "Pacman Won (: ", " Game Status ",
					  JOptionPane.INFORMATION_MESSAGE);
		  }	
	  } 	
       
		/*gatter setter*/  
		public IStatePacman getState() {
			return state;
		}
		
		public void setState(IStatePacman state) {
			this.state = state;
		}
	
		public Personage_pacman getPacman(){
			return pacman;
		}
		
		public Bord[][] getBorde(){
			  return this.borde;
		  }
			
		public int getNumberPacgammes(){
			  return numberPacgammes;
		  }
			
		public void setNumberPacgammes(){
			  numberPacgammes--;
			}

		 public void setPacman(Personage_pacman pacman) {
				this.pacman = pacman;
			}
		
		
} 
	
