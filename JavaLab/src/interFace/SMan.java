package interFace;

//ctrl +1 : add unimplement method
//型態(多型): Notebook, Accountant
public class SMan implements Lawyer, Accountant {

	private static void main(String[] args) {

		SMan s = new SMan();
		s.訴訟();
		s.報稅();
	}

	@Override
	public void 訴訟() {

	};

	@Override
	public void 報稅() {

	};//lambda
}
