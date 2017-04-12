using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Data;

namespace FormProject
{
    class Library
    {
        private string chuoiketnoi;
        private DataTable dataTable;
        public void connectDB(string lenhSql)
        {
            chuoiketnoi = "server =.\\SQLEXPRESS; database = QUANLY_BANHANG; Integrated security = true";
            SqlConnection sqlKetnoi = new SqlConnection(chuoiketnoi);
            SqlDataAdapter sqlAdapter = new SqlDataAdapter(lenhSql, sqlKetnoi);
            SqlCommandBuilder sqlCmnBuild = new SqlCommandBuilder(sqlAdapter);
            dataTable = new DataTable();
            sqlAdapter.Fill(dataTable);
            sqlAdapter.FillSchema(dataTable, SchemaType.Mapped);

            
        }

    }

}



    

