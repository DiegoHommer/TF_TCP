package Game.Character;

import java.util.ArrayList;

import Game.Character.Skill.Skill;

public abstract class Character {
    protected String spritePath;
    protected String name;
    protected int life;
    protected int maxLife;
    protected int shield;
    protected int maxShield;
    protected int skillPoints;
    protected int maxSkillPoints;
    protected ArrayList<Skill> activeSkills;
    
    protected Character(String spritePath, String name, int life, int maxShield, int skillPoints, ArrayList<Skill> activeSkills)
    {
        this.setSpritePath(spritePath);
        this.setName(name);
        this.setMaxLife(life);
        this.setLife(life);
        this.setMaxShield(maxShield);
        this.setShield(0);
        this.setMaxSkillPoints(skillPoints);
        this.setSkillPoints(skillPoints);
        this.setActiveSkills(activeSkills);
    }

    public String getName() {
        return name;
    }
    public boolean setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
            return true;
        }
        return false;
    }

    public String getSpritePath() {
        return spritePath;
    }
    public boolean setSpritePath(String spritePath) {
        if (spritePath != null && !spritePath.isEmpty()) {
            this.spritePath = spritePath;
            return true;
        }
        return false;
    }

    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        final int clampedLife = Math.max(0, Math.min(getMaxLife(), life)); // 0 <= life <= maxLife
        this.life = clampedLife;
    }

    public int getShield() {
        return shield;
    }
    public void setShield(int shield) {
        final int clampedShield = Math.max(0, Math.min(getMaxShield(), shield)); // 0 <= shield <= maxShield
        this.shield = clampedShield;
    }

    public ArrayList<Skill> getActiveSkills() {
        return activeSkills;
    }
    public boolean setActiveSkills(ArrayList<Skill> activeSkills) {
        if (activeSkills != null) {
            this.activeSkills = activeSkills;
            return true;
        }
        return false;
    }

    public int getMaxLife() {
        return maxLife;
    }
    public boolean setMaxLife(int maxLife) {
        if (maxLife > 0) {
            this.maxLife = maxLife;
            return true;
        }
        return false;
    }

    public int getMaxShield() {
        return maxShield;
    }
    public boolean setMaxShield(int maxShield) {
        if (maxShield >= 0) {
            this.maxShield = maxShield;
            return true;
        }
        return false;
    }

    public int getSkillPoints() {
        return skillPoints;
    }
    public void setSkillPoints(int skillPoints) {
        final int clampedSkillPoints = Math.max(0, Math.min(getMaxSkillPoints(), skillPoints)); // 0 <= skillPoints <= skillPointsMax
        this.skillPoints = clampedSkillPoints;
    }

    public int getMaxSkillPoints() {
        return maxSkillPoints;
    }
    public boolean setMaxSkillPoints(int maxSkillPoints) {
        if (maxSkillPoints >= 0) {
            this.maxSkillPoints = maxSkillPoints;
            return true;
        }
        return false;
    }
    public boolean deleteSkill(int selectedSkill) {
        if (selectedSkill >= 0 && selectedSkill < activeSkills.size()) {
            activeSkills.remove(selectedSkill);
            return true;
        }
        return false;
    }

    public boolean isDead(){
        return this.getLife() == 0;
    }

    public void resetStatus()
    {
        life = maxLife;
        skillPoints = maxSkillPoints;
        shield = 0;
    }

    public String GetInfoText()
    {
        return "<html>" + 
        name + 
        "<br>Life: " + Integer.toString(life) +
        "<br>Skill Points: " + Integer.toString(skillPoints) +
        "<br>Shield: " + Integer.toString(shield) + 
        "</html>";
    }
}
