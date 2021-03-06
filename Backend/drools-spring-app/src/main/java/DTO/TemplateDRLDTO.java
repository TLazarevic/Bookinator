package DTO;

import sbnz.integracija.example.facts.Member;
import sbnz.integracija.example.facts.Member.cathegory;

public class TemplateDRLDTO {
	private int minRent;
	private int maxRent;
	private int bronzeMinRent;
	private int bronzeMaxRent;
	private int silverMinRent;
	private int silverMaxRent;
	private int goldMinRent;
	private int goldMaxRent;
	/*private Member.cathegory previousCategory;
	private Member.cathegory newCategory;*/


	
	
	public TemplateDRLDTO() {
		super();
	}
	
	
	






	


	public int getMinRent() {
		return minRent;
	}
	public void setMinRent(int minRent) {
		this.minRent = minRent;
	}
	public int getMaxRent() {
		return maxRent;
	}
	public void setMaxRent(int maxRent) {
		this.maxRent = maxRent;
	}



	public int getBronzeMinRent() {
		return bronzeMinRent;
	}



	public void setBronzeMinRent(int bronzeMinRent) {
		this.bronzeMinRent = bronzeMinRent;
	}



	public int getBronzeMaxRent() {
		return bronzeMaxRent;
	}



	public void setBronzeMaxRent(int bronzeMaxRent) {
		this.bronzeMaxRent = bronzeMaxRent;
	}



	public int getSilverMinRent() {
		return silverMinRent;
	}



	public void setSilverMinRent(int silverMinRent) {
		this.silverMinRent = silverMinRent;
	}



	public int getSilverMaxRent() {
		return silverMaxRent;
	}



	public void setSilverMaxRent(int silverMaxRent) {
		this.silverMaxRent = silverMaxRent;
	}



	public int getGoldMinRent() {
		return goldMinRent;
	}



	public void setGoldMinRent(int goldMinRent) {
		this.goldMinRent = goldMinRent;
	}



	public int getGoldMaxRent() {
		return goldMaxRent;
	}



	public void setGoldMaxRent(int goldMaxRent) {
		this.goldMaxRent = goldMaxRent;
	}


	


	/*public Member.cathegory getPreviousCategory() {
		return previousCategory;
	}




	public void setPreviousCategory(Member.cathegory previousCategory) {
		this.previousCategory = previousCategory;
	}




	public Member.cathegory getNewCategory() {
		return newCategory;
	}




	public void setNewCategory(Member.cathegory newCategory) {
		this.newCategory = newCategory;
	}

*/










	public TemplateDRLDTO(int minRent, int maxRent, int bronzeMinRent, int bronzeMaxRent, int silverMinRent,
			int silverMaxRent, int goldMinRent, int goldMaxRent/*, cathegory previousCategory, cathegory newCategory*/) {
		super();
		this.minRent = minRent;
		this.maxRent = maxRent;
		this.bronzeMinRent = bronzeMinRent;
		this.bronzeMaxRent = bronzeMaxRent;
		this.silverMinRent = silverMinRent;
		this.silverMaxRent = silverMaxRent;
		this.goldMinRent = goldMinRent;
		this.goldMaxRent = goldMaxRent;
		/*this.previousCategory = previousCategory;
		this.newCategory = newCategory;*/
	}












	@Override
	public String toString() {
		return "TemplateDRLDTO [minRent=" + minRent + ", maxRent=" + maxRent + ", bronzeMinRent=" + bronzeMinRent
				+ ", bronzeMaxRent=" + bronzeMaxRent + ", silverMinRent=" + silverMinRent + ", silverMaxRent="
				+ silverMaxRent + ", goldMinRent=" + goldMinRent + ", goldMaxRent=" + goldMaxRent
				/*+ ", previousCategory=" + previousCategory + ", newCategory=" + newCategory +*/ + "]";
	}




	
	
	
	

}
