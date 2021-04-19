package scarlet.machado.lmsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*


class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        /*variáveis padrões*/
        val nome_padrao = "aluno"
        val senha_padrao = "impacta"

/*
        image_login.setImageResource(R.drawable.imagem_login)
*/

        botao_login.setOnClickListener {
            val nome = campo_usuario.text.toString()
            val senha = campo_senha.text.toString()

            if (nome == "" || senha == "") {
                Toast.makeText(this, "Preencher todos os campos!!!", Toast.LENGTH_LONG).show()
                campo_usuario.requestFocus()
            } else {
                if (nome != nome_padrao || senha != senha_padrao) {
                    Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)/*volta pra activity de login*/
                } else {
                    Toast.makeText(this, "Validado", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, TelaInicialActivity::class.java)
                    startActivity(intent)
                }

                /*val params = Bundle()
            params.putString("nome", nome)
            params.putInt("numero", 10)
            var array: ArrayList<Int> = ArrayList<Int>()
            array.add(10)
            array.add(20)
            params.putIntegerArrayList("array_numeros", array)

            intent.putExtras(params)
            intent.putExtra("outro_parametro", true)

            startActivity(intent)*/
            }

        }

    }
}
