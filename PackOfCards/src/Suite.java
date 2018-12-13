
enum Suite {
	Club(1),Diamond(2), Heart(3),Spade(4);
	int value;
	Suite(int v) {
		value = v;
	}
	public int getSuiteValue() {
		return value;
	}

}
