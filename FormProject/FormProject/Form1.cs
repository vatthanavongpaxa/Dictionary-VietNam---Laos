using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;
using System.Data;

namespace FormProject
{
    public partial class Form1 : Form
    {
        string array = null;
        public Form1()
        {
            InitializeComponent();
            loadData();
        }

        private void button_inSert_Click(object sender, EventArgs e)
        {
            string vnWord = textBox_vnWord.Text;
            string laWord = textBox_laWord.Text;

            SqlConnection sqlConn = new SqlConnection("server =DESKTOP-JL209BM; database = TUDIEN_VN_LAO; Integrated security = true");
            sqlConn.Open();
            SqlCommand sqlCmd = new SqlCommand("sp_AddWord", sqlConn);
            sqlCmd.CommandType = CommandType.StoredProcedure;
            sqlCmd.Parameters.AddWithValue("@VNWORD", vnWord);
            sqlCmd.Parameters.AddWithValue("@LAWORD", laWord);
            sqlCmd.ExecuteNonQuery();

            sqlConn.Close();
            textBox_laWord.Clear();
            textBox_vnWord.Clear();
            textBox1.Clear();
            loadData();
            label_status.Text = "Insert complete";


        }
        public void loadData()
        {
            array = null;
            SqlConnection sqlConn = new SqlConnection("server =DESKTOP-JL209BM; database = TUDIEN_VN_LAO; Integrated security = true");
            sqlConn.Open();
            SqlCommand sqlCmd = new SqlCommand("sp_AllWord", sqlConn);
            sqlCmd.CommandType = CommandType.StoredProcedure;
            sqlCmd.ExecuteNonQuery();

            DataTable dt = new DataTable();
            SqlDataAdapter sqlAdapter = new SqlDataAdapter(sqlCmd);
            sqlAdapter.Fill(dt);
            dataGridView_table.DataSource = dt;

            dataGridView_table.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.AllCells;

            foreach (DataRow row in dt.Rows)
            {
                string vnWord = row["VNWORD"].ToString();
                string laWord = row["LAWORD"].ToString();
                array = "INSERT INTO TUDIEN (VNWORD,LAWORD) VALUES ('" + vnWord + "','" + laWord + "');" + Environment.NewLine;
                textBox1.Text += array;
            }
            int nRowIndex = dataGridView_table.Rows.Count - 1;
            int nColumnIndex = 3;

            dataGridView_table.Rows[nRowIndex].Selected = true;
            dataGridView_table.Rows[nRowIndex].Cells[nColumnIndex].Selected = true;

            sqlConn.Close();

            textBox_vnWord.Focus();

        }

        private void dataGridView_table_SelectionChanged(object sender, EventArgs e)
        {
            if (dataGridView_table.Rows[0].Selected == true)
            {
                textBox_vnWord.Text = "";
                textBox_laWord.Text = "";
            }
            else
            {
                if (dataGridView_table.SelectedCells.Count > 0)
                {

                    textBox_search.Text = "";
                    int selectedRowIndex = dataGridView_table.SelectedCells[0].RowIndex;
                    DataGridViewRow selectRow = dataGridView_table.Rows[selectedRowIndex];
                    string vnWord = Convert.ToString(selectRow.Cells["VNWORD"].Value);
                    string laWord = Convert.ToString(selectRow.Cells["LAWORD"].Value);

                    textBox_vnWord.Text = vnWord;
                    textBox_laWord.Text = laWord;
                    button_Update.Visible = true;
                }
            }

        }
        private void button_delete_Click(object sender, EventArgs e)
        {

            int selectedRowIndex = dataGridView_table.SelectedCells[0].RowIndex;
            DataGridViewRow selectRow = dataGridView_table.Rows[selectedRowIndex];
            int id = Convert.ToInt32(selectRow.Cells["ID"].Value);

            SqlConnection sqlConn = new SqlConnection("server =DESKTOP-JL209BM; database = TUDIEN_VN_LAO; Integrated security = true");
            sqlConn.Open();
            SqlCommand sqlCmd = new SqlCommand("sp_DeleteWord", sqlConn);

            sqlCmd.CommandType = CommandType.StoredProcedure;
            sqlCmd.Parameters.AddWithValue("@ID", id);
            sqlCmd.ExecuteNonQuery();
            sqlConn.Close();
            textBox1.Clear();
            loadData();
            label_status.Text = "Delete complete!";
        }

        private void button_Update_Click(object sender, EventArgs e)
        {
            int selectedRowIndex = dataGridView_table.SelectedCells[0].RowIndex;
            DataGridViewRow selectRow = dataGridView_table.Rows[selectedRowIndex];
            int id = Convert.ToInt32(selectRow.Cells["ID"].Value);
            string vnWord = textBox_vnWord.Text;
            string laWord = textBox_laWord.Text;

            SqlConnection sqlConn = new SqlConnection("server =DESKTOP-JL209BM; database = TUDIEN_VN_LAO; Integrated security = true");
            sqlConn.Open();
            SqlCommand sqlCmd = new SqlCommand("sp_UpdateWord", sqlConn);

            sqlCmd.CommandType = CommandType.StoredProcedure;
            sqlCmd.Parameters.AddWithValue("@ID", id);
            sqlCmd.Parameters.AddWithValue("@VNWORD", vnWord);
            sqlCmd.Parameters.AddWithValue("@LAWORD", laWord);
            sqlCmd.ExecuteNonQuery();
            sqlConn.Close();
            textBox1.Clear();
            loadData();
            label_status.Text = "Update complete!";

        }

        private void button_search_Click(object sender, EventArgs e)
        {
            string vnWord = textBox_search.Text;
            SqlConnection sqlConn = new SqlConnection("server =DESKTOP-JL209BM; database = TUDIEN_VN_LAO; Integrated security = true");
            sqlConn.Open();
            SqlCommand sqlCmd = new SqlCommand("sp_SeachVnWord", sqlConn);

            sqlCmd.CommandType = CommandType.StoredProcedure;
            sqlCmd.Parameters.AddWithValue("@VNWORD", vnWord);
            sqlCmd.ExecuteNonQuery();

            DataTable dt = new DataTable();
            SqlDataAdapter sqlAdapter = new SqlDataAdapter(sqlCmd);
            sqlAdapter.Fill(dt);
            dataGridView_table.DataSource = dt;

            sqlConn.Close();
            label_status.Text = "Search complete";
        }
    }
}
