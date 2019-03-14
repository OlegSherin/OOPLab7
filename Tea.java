public class Tea {
	private String name, weight, packaging;

	public Tea(String name, String weight, String packaging) {
		this.name = name;
		this.weight = weight;
		this.packaging = packaging;
	}

	@Override
	public String toString() {
		return "Напиток:  " + name + ";  вес:  " + weight + ";  тип упаковки:  " + packaging
				+ "\n";
	}
}
