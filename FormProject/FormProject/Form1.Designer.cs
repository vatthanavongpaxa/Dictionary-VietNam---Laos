namespace FormProject
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.groupBox = new System.Windows.Forms.GroupBox();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.button_search = new System.Windows.Forms.Button();
            this.textBox_search = new System.Windows.Forms.TextBox();
            this.label_search = new System.Windows.Forms.Label();
            this.button_Update = new System.Windows.Forms.Button();
            this.label_statusText = new System.Windows.Forms.Label();
            this.label_status = new System.Windows.Forms.Label();
            this.button_delete = new System.Windows.Forms.Button();
            this.button_inSert = new System.Windows.Forms.Button();
            this.textBox_laWord = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.textBox_vnWord = new System.Windows.Forms.TextBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.dataGridView_table = new System.Windows.Forms.DataGridView();
            this.groupBox.SuspendLayout();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView_table)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox
            // 
            this.groupBox.Controls.Add(this.textBox1);
            this.groupBox.Controls.Add(this.button_search);
            this.groupBox.Controls.Add(this.textBox_search);
            this.groupBox.Controls.Add(this.label_search);
            this.groupBox.Controls.Add(this.button_Update);
            this.groupBox.Controls.Add(this.label_statusText);
            this.groupBox.Controls.Add(this.label_status);
            this.groupBox.Controls.Add(this.button_delete);
            this.groupBox.Controls.Add(this.button_inSert);
            this.groupBox.Controls.Add(this.textBox_laWord);
            this.groupBox.Controls.Add(this.label2);
            this.groupBox.Controls.Add(this.label1);
            this.groupBox.Controls.Add(this.textBox_vnWord);
            this.groupBox.Location = new System.Drawing.Point(12, 12);
            this.groupBox.Name = "groupBox";
            this.groupBox.Size = new System.Drawing.Size(999, 280);
            this.groupBox.TabIndex = 0;
            this.groupBox.TabStop = false;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(520, 12);
            this.textBox1.Multiline = true;
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(473, 187);
            this.textBox1.TabIndex = 13;
            // 
            // button_search
            // 
            this.button_search.Location = new System.Drawing.Point(318, 12);
            this.button_search.Name = "button_search";
            this.button_search.Size = new System.Drawing.Size(75, 30);
            this.button_search.TabIndex = 11;
            this.button_search.Text = "Search";
            this.button_search.UseVisualStyleBackColor = true;
            this.button_search.Click += new System.EventHandler(this.button_search_Click);
            // 
            // textBox_search
            // 
            this.textBox_search.Location = new System.Drawing.Point(156, 16);
            this.textBox_search.Name = "textBox_search";
            this.textBox_search.Size = new System.Drawing.Size(156, 22);
            this.textBox_search.TabIndex = 10;
            // 
            // label_search
            // 
            this.label_search.AutoSize = true;
            this.label_search.Location = new System.Drawing.Point(7, 22);
            this.label_search.Name = "label_search";
            this.label_search.Size = new System.Drawing.Size(53, 17);
            this.label_search.TabIndex = 9;
            this.label_search.Text = "Search";
            // 
            // button_Update
            // 
            this.button_Update.Location = new System.Drawing.Point(237, 192);
            this.button_Update.Name = "button_Update";
            this.button_Update.Size = new System.Drawing.Size(75, 30);
            this.button_Update.TabIndex = 8;
            this.button_Update.Text = "Update";
            this.button_Update.UseVisualStyleBackColor = true;
            this.button_Update.Visible = false;
            this.button_Update.Click += new System.EventHandler(this.button_Update_Click);
            // 
            // label_statusText
            // 
            this.label_statusText.AutoSize = true;
            this.label_statusText.Location = new System.Drawing.Point(7, 216);
            this.label_statusText.Name = "label_statusText";
            this.label_statusText.Size = new System.Drawing.Size(56, 17);
            this.label_statusText.TabIndex = 7;
            this.label_statusText.Text = "Status: ";
            // 
            // label_status
            // 
            this.label_status.AutoSize = true;
            this.label_status.Location = new System.Drawing.Point(69, 216);
            this.label_status.Name = "label_status";
            this.label_status.Size = new System.Drawing.Size(0, 17);
            this.label_status.TabIndex = 6;
            // 
            // button_delete
            // 
            this.button_delete.Location = new System.Drawing.Point(318, 192);
            this.button_delete.Name = "button_delete";
            this.button_delete.Size = new System.Drawing.Size(75, 30);
            this.button_delete.TabIndex = 5;
            this.button_delete.Text = "Delete";
            this.button_delete.UseVisualStyleBackColor = true;
            this.button_delete.Click += new System.EventHandler(this.button_delete_Click);
            // 
            // button_inSert
            // 
            this.button_inSert.Location = new System.Drawing.Point(156, 192);
            this.button_inSert.Name = "button_inSert";
            this.button_inSert.Size = new System.Drawing.Size(75, 30);
            this.button_inSert.TabIndex = 4;
            this.button_inSert.Text = "Insert";
            this.button_inSert.UseVisualStyleBackColor = true;
            this.button_inSert.Click += new System.EventHandler(this.button_inSert_Click);
            // 
            // textBox_laWord
            // 
            this.textBox_laWord.Font = new System.Drawing.Font("Noto Sans Lao", 16.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.textBox_laWord.Location = new System.Drawing.Point(156, 93);
            this.textBox_laWord.Multiline = true;
            this.textBox_laWord.Name = "textBox_laWord";
            this.textBox_laWord.ScrollBars = System.Windows.Forms.ScrollBars.Both;
            this.textBox_laWord.Size = new System.Drawing.Size(341, 93);
            this.textBox_laWord.TabIndex = 3;
            this.textBox_laWord.WordWrap = false;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(6, 93);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(70, 17);
            this.label2.TabIndex = 2;
            this.label2.Text = "Lao Word";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 54);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(99, 17);
            this.label1.TabIndex = 1;
            this.label1.Text = "VietNam Word";
            // 
            // textBox_vnWord
            // 
            this.textBox_vnWord.CharacterCasing = System.Windows.Forms.CharacterCasing.Upper;
            this.textBox_vnWord.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.textBox_vnWord.Location = new System.Drawing.Point(156, 44);
            this.textBox_vnWord.Name = "textBox_vnWord";
            this.textBox_vnWord.Size = new System.Drawing.Size(255, 30);
            this.textBox_vnWord.TabIndex = 0;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.dataGridView_table);
            this.groupBox1.Location = new System.Drawing.Point(12, 298);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(999, 287);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Table";
            // 
            // dataGridView_table
            // 
            this.dataGridView_table.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView_table.Location = new System.Drawing.Point(0, 21);
            this.dataGridView_table.MultiSelect = false;
            this.dataGridView_table.Name = "dataGridView_table";
            this.dataGridView_table.RowTemplate.Height = 24;
            this.dataGridView_table.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.CellSelect;
            this.dataGridView_table.Size = new System.Drawing.Size(993, 280);
            this.dataGridView_table.TabIndex = 0;
            this.dataGridView_table.SelectionChanged += new System.EventHandler(this.dataGridView_table_SelectionChanged);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1024, 597);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.groupBox);
            this.Name = "Form1";
            this.Text = "Add Word";
            this.groupBox.ResumeLayout(false);
            this.groupBox.PerformLayout();
            this.groupBox1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView_table)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox;
        private System.Windows.Forms.TextBox textBox_laWord;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBox_vnWord;
        private System.Windows.Forms.Button button_delete;
        private System.Windows.Forms.Button button_inSert;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.DataGridView dataGridView_table;
        private System.Windows.Forms.Label label_statusText;
        private System.Windows.Forms.Label label_status;
        private System.Windows.Forms.Button button_Update;
        private System.Windows.Forms.TextBox textBox_search;
        private System.Windows.Forms.Label label_search;
        private System.Windows.Forms.Button button_search;
        private System.Windows.Forms.TextBox textBox1;
    }
}

