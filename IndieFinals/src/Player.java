public class Player extends Creature {
        String name="";
        int terrain;

        public void setName(String newName){
            name = newName;
        }
        public boolean isInDifficultTerrain(){
            return terrain==0;
        }
        public boolean isProne(){
            return stance==0;
        }

}
