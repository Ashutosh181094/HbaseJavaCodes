import java.io.IOException;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.conf.Configuration;

public class CreateTable {

	public static void main(String[] args) throws IOException {

		// Instantiating configuration class
		Configuration con = HBaseConfiguration.create();

		// Instantiating HbaseAdmin class
		HBaseAdmin admin = new HBaseAdmin(con);

		if(admin.tableExists("emp".getBytes())){
			admin.disableTable("emp".getBytes());
			admin.deleteTable("emp".getBytes());
		}

		// Instantiating table descriptor class
		HTableDescriptor tableDescriptor = new HTableDescriptor("emp".getBytes());

		// Adding column families to table descriptor
		tableDescriptor.addFamily(new HColumnDescriptor("personal".getBytes()));
		tableDescriptor.addFamily(new HColumnDescriptor("professional".getBytes()));

		// Execute the table through admin
		admin.createTable(tableDescriptor);
		System.out.println(" Table created ");
	}
}