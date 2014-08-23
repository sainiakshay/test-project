package TransferObjects;

public class SpecificationsTO {
	
	private int  clumpThickness;
	private int  uniformityOfCellSize;
	private int  uniformityOfCellShape;
	private int  marginalAdhesion;
	private int  singleEpithelialCellSize;
	private String  bareNuclei;
	private int  blandChromatin;
	private int  normalNucleoli;
	private int  mitoses;
	private double  cancerClass;
	
	public int getNormalNucleoli() {
		return normalNucleoli;
	}
	public void setNormalNucleoli(int normalNucleoli) {
		this.normalNucleoli = normalNucleoli;
	}
	public int getMitoses() {
		return mitoses;
	}
	public void setMitoses(int mitoses) {
		this.mitoses = mitoses;
	}
	
	public int getClumpThickness() {
		return clumpThickness;
	}
	public void setClumpThickness(int clumpThickness) {
		this.clumpThickness = clumpThickness;
	}
	public int getUniformityOfCellSize() {
		return uniformityOfCellSize;
	}
	public void setUniformityOfCellSize(int uniformityOfCellSize) {
		this.uniformityOfCellSize = uniformityOfCellSize;
	}
	public int getUniformityOfCellShape() {
		return uniformityOfCellShape;
	}
	public void setUniformityOfCellShape(int uniformityOfCellShape) {
		this.uniformityOfCellShape = uniformityOfCellShape;
	}
	public int getMarginalAdhesion() {
		return marginalAdhesion;
	}
	public void setMarginalAdhesion(int marginalAdhesion) {
		this.marginalAdhesion = marginalAdhesion;
	}
	public int getSingleEpithelialCellSize() {
		return singleEpithelialCellSize;
	}
	public void setSingleEpithelialCellSize(int singleEpithelialCellSize) {
		this.singleEpithelialCellSize = singleEpithelialCellSize;
	}
	
	public String getBareNuclei() {
		return bareNuclei;
	}
	public void setBareNuclei(String bareNuclei) {
		this.bareNuclei = bareNuclei;
	}
	public int getBlandChromatin() {
		return blandChromatin;
	}
	public void setBlandChromatin(int blandChromatin) {
		this.blandChromatin = blandChromatin;
	}
	public double getCancerClass() {
		return cancerClass;
	}
	public void setCancerClass(double cancerClass) {
		this.cancerClass = cancerClass;
	}
	

	

}
