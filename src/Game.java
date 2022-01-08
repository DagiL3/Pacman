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
	
	int index=0 ;
	
	/**
	 * @brief Ajoute les 4 direction dans le tableau direction et direction1
	 * */
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
	
	/**
	 * @brief ajoute les 4 couleurs dans le tableau colors
	 * */	
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
	
	/**
	 * @brief  limite la durée de pouvoir de pacman 
	 * */
	public void verifyTimingState(){
		if(System.currentTimeMillis()>Timer1_End ) {
			initalizeColor();
			pacman.setColor(1);
			setState(stateNormal);
			Timer1_Start=0;
			Timer1_End=0;
		}
	}
	
	/**
	 * @brief  change d etat selon les types de pac gomme
	 * @param p est pacgomme
	 */
	public void addPoints(MyPacgomme p){
		if(p==null)return;
		if(p.getPacgome()==null)return;
		switch(p.getPacgome()){	 
		case BLEU:
			pacman.setPoint(100);
			break;
		case ORANGE:
			pacman.setPoint(500);
			initalizeColorBlue();
			pacman.setColor(8);//orenge			 
			Timer1_Start=System.currentTimeMillis();
			Timer1_End=Timer1_Start+10000;
			setState(stateSuper);
			break;
		case VIOLET:
			pacman.setPoint(300);
			initalizeColor();
			pacman.setColor(7);//7:pale yellow
			Timer1_Start=System.currentTimeMillis();
			Timer1_End=Timer1_Start+10000;
			setState(stateInvisible);
			break;
		case VERT:
			pacman.setPoint(1000);
			changeLabyrinthes();
			break;
		}		
	}	

	/**
	 * @brief pour obtenir le case spécifie
	 * @param y est possiton en axe vertical
	 * @param  x est possiton en axe horizontal 
	 * @return une case de la grille 
	 */
	public Bord getCell(int posX,int posY){
		return borde[posX][posY];
	}
	
	/** 
	 * @brief move le case b à la position (posx, posy)
	 * @param  x est possiton en axe horizontal 
	 * @param y est possiton en axe vertical
	 * @param  b est le case a deplace
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
	
	/** 
	 * @brief move pacman a la position (posx, posy)
	 * @param  x est possiton en axe horizontal 
	 * @param y est possiton en axe vertical
	 * @param  pacman est le case a deplace
	 * */
	public void setCell(int posX,int posY,Personage_pacman pacman){
		borde[posX][posY].setType((Element) pacman.getType());
		borde[posX][posY].setPacman(pacman);
	}
	
	/** 
	 * @brief move b a la position (posx, posy) par apport le fantoms
	 * @param  x est possiton en axe horizontal 
	 * @param y est possiton en axe vertical
	 * @param  b est le case a deplace
	 * */
	public void  setCellNullF(int posX,int posY, Bord b){
		if(b.getType()==Element.OBSTACLE)return;
		if(b.getType()==Element.PACGOMME||b.getType()==Element.EMPTY) {
			borde[posX][posY].setType(b.getType());	
			borde[posX][posY].setPacgome(b.getMyPacgome());
		}
		else if(b.getType()==Element.PACMAN) {
			borde[posX][posY].setType(Element.PACMAN);
			borde[posX][posY].setPacman(b.getPacman());
		}
		else if(b.getType()==Element.FANTOME){
			borde[posX][posY].setType(Element.FANTOME);
			borde[posX][posY].setFantom1(b.getFantom1());
			borde[posX][posY].getFantom1().setColor(b.getFantom1().getColor());
		}
	}
		  
	/** 
	 * @brief move fantome a la position (posx, posy)
	 * @param  x est possiton en axe horizontal 
	 * @param y est possiton en axe vertical
	 * @param  fantome est le case a deplace
	 * */
	public void setCellF(int posX,int posY,Personage_fantome fantome){
		borde[posX][posY].setType((Element)fantome.getType());
		borde[posX][posY].setFantom1(fantome);
		borde[posX][posY].getFantom1().setColor(fantome.getColor());
	}
		
	/**
	 *  @brief Eviter les fantomes de choisir  le meme direction
	*/
	Direction getRandom(){
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
		else{	   
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
 
	/** 
	 * @brief move fantome au centre 
	 * @param fx est possiton en axe horizontal 
	 * @param fy est possiton en axe vertical
	 * @param  i un element de tableau posxCenterFantom pour choisir le centre de la grille 
	 * */
	public void FantomeToCentre(int i,int fx,int fy){
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
			return;
		}
		setCellF(x,y,fantome.getFantom1()); 
		fantome.getFantom1().setPosX(x);
		fantome.getFantom1().setPosY(y);
	}
        
	public void movePacman(){
		state.movePacman();
	}
	
	public void moveFantome(){	
		state.moveFantome();
	}
	  
	/**
	 * @brief pour initialiser la couleur des fantomes du bleu a leur couleur d origine
	 *  */
	public void initalizeColor(){
		for(int i=1;i<=4;i++){
			MyFantome[i-1].setColor(i);
		}
	}
	
	/**
	 * @brief  pour initialiser la couleur des fantomes du leur couleur d origine au bleu 
	 * */
	public void initalizeColorBlue(){
		for(int i=0;i<4;i++){
			MyFantome[i].setColor(11);
		}
	}

	/**
	 * @brief  changer la forme des labyrinthes
	 * */
	public void changeLabyrinthes(){	 
		borde[4][5]=new Bord(new MyPacgomme(Pacgomme.BLEU,4,5));
		borde[3][7]=new Bord(new MyPacgomme(Pacgomme.BLEU,3,7));
		borde[4][1]=new Bord(new MyPacgomme(Pacgomme.BLEU,4,1));
		numberPacgammes=numberPacgammes+3;
	}
	
	/**
	 * @brief afficher l etat du jeu
	 * */
	public void afficheStatus(){
		if(pacman.getVie()==0) {
			JOptionPane.showMessageDialog(null, "Game Over ): ", " Game Status ",
					JOptionPane.INFORMATION_MESSAGE);		  
		}else if(pacman.getVie()>0&&getNumberPacgammes()<=0) {
			JOptionPane.showMessageDialog(null, "Pacman Won (: ", " Game Status ",
					JOptionPane.INFORMATION_MESSAGE);
		}	
	} 	
    
	/*********************************Getters and Setters*************************************************************/  
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
	
