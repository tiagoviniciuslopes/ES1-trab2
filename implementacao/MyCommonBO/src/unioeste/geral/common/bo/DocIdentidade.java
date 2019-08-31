package unioeste.geral.common.bo;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DocIdentidade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String numeroDoc;

	private Date dataExpedicao;

	private OrgaoExpeditor orgaoExpeditor;

	public String getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public String getSQLData() {
		if (dataExpedicao == null)
			return "null";
		SimpleDateFormat stringify = new SimpleDateFormat("yyyy-MM-dd");
		return "'" + stringify.format(dataExpedicao) + "'";
	}
	public String getStringData() {
		SimpleDateFormat stringify = new SimpleDateFormat("dd/MM/yyyy");
		return stringify.format(dataExpedicao);
	}
	public boolean setDataExpedicao(String data) {
		String format = "dd/MM/yyyy";
		if (data.indexOf("-") != -1) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat parser = new SimpleDateFormat(format);
		try {
			this.dataExpedicao = parser.parse(data);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}
	
	public Date getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(Date dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public OrgaoExpeditor getOrgaoExpeditor() {
		return orgaoExpeditor;
	}

	public void setOrgaoExpeditor(OrgaoExpeditor orgaoExpeditor) {
		this.orgaoExpeditor = orgaoExpeditor;
	}

}
