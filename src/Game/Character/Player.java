package Game.Character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import Game.Character.Skill.Skill;
import Game.Character.Skill.Skills.ErrorSkill;

public class Player extends Character{
    private ArrayList<Skill> unlockedSkillsList;

    private static final int LP_INITIAL = 100;
    private static final int SP_INITIAL = 50;
    private static final int SH_INITIAL = 50;
    private static final int MAX_SKILL_INDEX = 3;
    private static final String SPRITE_PATH = "#toDo";

    public Player(String name){
        super(
            SPRITE_PATH, 
            name, 
            LP_INITIAL, 
            SH_INITIAL, 
            SP_INITIAL, 
            new ArrayList<>(Arrays.asList(new ErrorSkill(), new ErrorSkill(), new ErrorSkill(), new ErrorSkill())));
            
        this.unlockedSkillsList = new ArrayList<>();
    }
    
    public ArrayList<Skill> getUnlockedSkillsList() {
        return unlockedSkillsList;
    }

    public void setUnlockedSkillsList(ArrayList<Skill> unlockedSkillsList) {
        this.unlockedSkillsList = unlockedSkillsList;
    }

    //adiciona uma skill no array de skills desbloqueadas
    public boolean addSkill(Skill newSkill){
        ArrayList<Skill> unlockedSkills = this.getUnlockedSkillsList();

        //verifica se a skill já nao esta na lista de skills desbloqueada
        Iterator<Skill> iterator = unlockedSkills.iterator();
        while (iterator.hasNext()) {
            Skill skill = iterator.next();
            if(skill.getName() == newSkill.getName()){
                return false;
            }
        }

        unlockedSkills.add(newSkill);
        return true;
    }

    //coloca a skill selecionada no slot desejado
    public boolean setSkillSlot(Skill selectedSkill,int slot){
        if(slot < 0 || slot > MAX_SKILL_INDEX){
            return false;
        }else{
            ArrayList<Skill> activeList = this.getActiveSkills();
            activeList.set(slot, selectedSkill);
            return true;
        }
    }
}