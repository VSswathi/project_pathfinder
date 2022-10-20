package com.example.pathfinder.dto;





import lombok.Data;



@Data
public class AssetClassificationManagedServicesYear {

private int year;
    private long spendIncreaseWithInflation_m;
    private float industrialize_shiftleft;
    private float industrialize_automate;
    private float industrialize_realtime;
    private float synergize_selfservice;
    
    
    private float savingSubtotal_perc_m;
    private float savingSubtotal_value_m;

    
    public AssetClassificationManagedServicesYear(int year, float industrialize_shiftleft, float industrialize_automate,
			float industrialize_realtime, float synergize_selfservice) {
		super();
		this.year = year;
		this.industrialize_shiftleft = industrialize_shiftleft;
		this.industrialize_automate = industrialize_automate;
		this.industrialize_realtime = industrialize_realtime;
		this.synergize_selfservice = synergize_selfservice;
	}

    public AssetClassificationManagedServicesYear() {
    	 
    }
}