package net.mmberg.nadia.dialogmodel.definition.aqd;

public abstract class AQDContextModel {

		//TODO old Meaning.java -> adapt to AQD2
	
		//serializable members
		protected String specification;
		protected String reference;

		//Constructors
		public AQDContextModel(){
			
		}
		
		public AQDContextModel(String specification, String reference){
			this.specification=specification;
			this.reference=reference;
		}
		
		//Serialization getter/setter
		public String getSpecification() {
			return specification;
		}
		public void setSpecification(String specification) {
			this.specification = specification;
		}
		public String getReference() {
			return reference;
		}
		public void setReference(String reference) {
			this.reference = reference;
		}
		
}
