package in.tp.adb.dao;

public interface IQueryMapper {

	public static final String INS_CONT_QRY=
			"insert into contacts values(?,?,?,?)";
	public static final String UPD_CONT_QRY=
			"update contacts set cnm=?,mno=?,mail=? where cid=?";
	public static final String DEL_CONT_QRY=
			"delete from contacts where cid=?";
	public static final String GET_ALL_CONT_QRY=
			"select * from contacts";
	public static final String GET_CONT_BY_ID_QRY=
			"select * from contacts where cid=?";
}
