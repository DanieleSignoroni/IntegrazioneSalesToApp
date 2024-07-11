package it.softre.thip.base.connettori.salesToApp;
public enum TipiAccount {
		CLIENTE(1), PROSPECT(2), FORNITORE(3), PARTNER(4), RIVENDITORE(7), DISTRIBUTORE(9);

		private int value;

		private TipiAccount(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}