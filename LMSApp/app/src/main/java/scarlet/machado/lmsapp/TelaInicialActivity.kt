package scarlet.machado.lmsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        var params = intent.extras
        val nome = params?.getString("nome")
        Toast.makeText(this, "Nome do usuário $nome", Toast.LENGTH_LONG).show()

        setSupportActionBar(toolbar)

        supportActionBar?.title = "TELA PRINCIPAL"
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id == R.id.action_buscar){
        }
        else if( id == R.id.action_add){
            Toast.makeText(this, "Botão de adicionar clicado",
                    Toast.LENGTH_LONG).show()
            val intent = Intent(this, CadastrarActivity::class.java) /*enviar para tela de cadastro*/
            startActivity(intent)

        }
        else if (id == R.id.action_sair){

        }
        else if (id == R.id.action_atualizar){

        }else if(id == R.id.action_confg){

        }else if(id == android.R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)

    }
}