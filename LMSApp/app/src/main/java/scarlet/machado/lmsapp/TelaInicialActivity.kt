package scarlet.machado.lmsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)


        var params = intent.extras
        val nome: String? = params?.getString("nome")
        Toast.makeText(this, "Nome do usuário $nome",
                Toast.LENGTH_LONG).show()
        setSupportActionBar(toolbar)
        supportActionBar?.title = "TELA PRINCIPAL"

//        supportActionBar?.setDisplayHomeAsUpEnabled // seta para voltar



        val btn_cardapio = findViewById<Button>(R.id.abrir_cardapio)
        val btn_comanda = findViewById<Button>(R.id.comandas)
        val btn_pedido = findViewById<Button>(R.id.anotar_pedido)


        /*CONFIGURANDO OS BOTÕES */
        clickBotoes(btn_cardapio, btn_pedido, btn_comanda)

    }

    private fun clickBotoes(btn_cardapio: Button, btn_pedido: Button, btn_comanda: Button) {
        btn_cardapio.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, AcoesBtnActivity::class.java) /*enviar para tela de cadastro*/
            Toast.makeText(this, " NAO IMPLEMENTADO",
                    Toast.LENGTH_LONG).show()
            startActivity(intent)
        })
        btn_pedido.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AcoesBtnActivity::class.java)/* enviar para tela de cadastro*/
            Toast.makeText(this, " NAO IMPLEMENTADO",
                    Toast.LENGTH_LONG).show()
            startActivity(intent)
        })
        btn_comanda.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AcoesBtnActivity::class.java) /*enviar para tela de cadastro*/
            Toast.makeText(this, " NAO IMPLEMENTADO",
                    Toast.LENGTH_LONG).show()
            startActivity(intent)
        })
    }

    /*INFLANDO O MENU*/
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    /*COLOCANDO OPÇÕES NO MENU*/
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id == R.id.action_buscar){
            Toast.makeText(this, "METODO DE BUSCAR NAO IMPLEMENTADO",
                    Toast.LENGTH_LONG).show()
        }
        else if( id == R.id.action_add){
            Toast.makeText(this, "Botão de adicionar clicado",
                    Toast.LENGTH_LONG).show()
            val intent = Intent(this, CadastrarActivity::class.java) /*enviar para tela de cadastro*/
            startActivity(intent)

        }
        else if (id == R.id.action_sair){
            Toast.makeText(this, "Botão de sair clicado",
                    Toast.LENGTH_LONG).show()
            finish()
            val intent = Intent(this, MainActivity::class.java)/* enviar para tela de cadastro*/

            startActivity(intent)


        }
        else if (id == R.id.action_atualizar){
            Toast.makeText(this, "METODO DE ATUALIZAR NAO IMPLEMENTADO",
                    Toast.LENGTH_LONG).show()

        }else if(id == R.id.action_confg){
            Toast.makeText(this, "BOTÃO DE CONFIGURAR CLICADO",
                    Toast.LENGTH_LONG).show()
            val intent = Intent(this, ConfigurarActivity::class.java) /*enviar para tela de cadastro*/
            startActivity(intent)

        }else if(id == android.R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)

    }
}