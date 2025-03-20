package controller.model.entities;

public class Components {
	private String element;
	private String quantity;
	
	public Components(String element, String quantity) {
		super();
		this.element = element;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return this.element + " - " + this.quantity;
	}
	
	@Override
	public Components clone() {
		return new Components(this.element, this.quantity);
	}

	public String getElement() {
		return this.element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
