package com.br.otavianosilverio.termouso;

import androidx.appcompat.app.AppCompatActivity ;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewHolder mViewMain = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewMain.edit_nome = this.findViewById(R.id.edit_nome);
        this.mViewMain.chec_aceite = this.findViewById(R.id.check_aceite);
        this.mViewMain.button_salvar = this.findViewById(R.id.button_salvar);
        this.mViewMain.rd_sexo = this.findViewById(R.id.Rd_sexo);

        // Identifica os objetos que são utilizados para ação
        this.mViewMain.button_salvar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        // Será tratado todos os eventos clique da tela
        // Botao salvar
        if (view.getId() == R.id.button_salvar){
            // Verificar se nome foi preenchido
            if (TextUtils.isEmpty(this.mViewMain.edit_nome.getText().toString())){
                this.mViewMain.edit_nome.setError("Informe o nome");
                this.mViewMain.edit_nome.requestFocus();
            }

            if (!this.mViewMain.chec_aceite.isChecked()){
                this.mViewMain.chec_aceite.setError("Você precisa concordar com os termos");
                this.mViewMain.chec_aceite.requestFocus();

            }
            // verificar o botao do sexo preenchido
            int itemRadioGroupSelecionado = this.mViewMain.rd_sexo.getCheckedRadioButtonId();

            if (itemRadioGroupSelecionado == -1){
                this.mViewMain.chec_aceite.setError("Você precisa definir o sexo");
                this.mViewMain.chec_aceite.requestFocus();
            }


        }
        //Botao sair

    }


    private static class ViewHolder{
        private EditText edit_nome;
        private Button button_salvar;
        private CheckBox chec_aceite;
        private RadioGroup  rd_sexo;
    }
}
