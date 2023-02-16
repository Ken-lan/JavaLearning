package Midterm;

public interface Statement {

	public static final String INSERT = "INSERT INTO [dbo].[product] VALUES(?,?,?,?,?,?,?)";
	public static final String INSERT_PIC = "INSERT picture VALUES(?,?,?)";
	public static final String DELETE = "DELETE FROM [dbo].[product] WHERE [name] LIKE ?";
	public static final String QUERY = "SELECT * FROM [dbo].[product] WHERE id = ?";
	public static final String QUERY_PIC = "SELECT * FROM [dbo].[picture] WHERE fileID = ?";
	public static final String UPDATE = "UPDATE [dbo].[prodct] SET price = ? WHERE id = ?";
	
}
