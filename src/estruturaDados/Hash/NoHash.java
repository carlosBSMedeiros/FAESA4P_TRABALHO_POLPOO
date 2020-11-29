package estruturaDados.Hash;

import java.util.ArrayList;
import models.PessoaBanco;

public class NoHash {
	private ArrayList<PessoaBanco> infos;

	public NoHash() {
		infos = new ArrayList<PessoaBanco>();
	}

	public ArrayList<PessoaBanco> getInfos() {
		return infos;
	}

	@Override
	public String toString() {
		String msg = "";

		for (PessoaBanco x : infos) {
			msg += x.toString() + "\n";
		}

		return msg;
	}

}
