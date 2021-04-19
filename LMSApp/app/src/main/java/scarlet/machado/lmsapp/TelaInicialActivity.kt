package scarlet.machado.lmsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        /**/

        var params = intent.extras
        val nome: String? = params?.getString("nome")
        Toast.makeText(
            this, "Nome do usuário $nome",
            Toast.LENGTH_LONG).show()
        var numero = params?.getInt("numero")

/*        setSupportActionBar(toolbar)*/
        supportActionBar?.title = "TELA PRINCIPAL"
        configuraMenuLateral()


        recycler_produtos?.layoutManager = LinearLayoutManager(this)
    }

//        supportActionBar?.setDisplayHomeAsUpEnabled // seta para voltar



       /* val btn_cardapio = findViewById<Button>(R.id.abrir_cardapio)
        val btn_comanda = findViewById<Button>(R.id.comandas)
        val btn_pedido = findViewById<Button>(R.id.anotar_pedido)


        *//*CONFIGURANDO OS BOTÕES *//*
        clickBotoesPrincipal(btn_cardapio, btn_pedido, btn_comanda)

    }

    private fun clickBotoesPrincipal(btn_cardapio: Button, btn_pedido: Button, btn_comanda: Button) {
        btn_cardapio.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ProdutosActivity::class.java) *//*enviar para tela de cadastro*//*
            Toast.makeText(this, " NAO IMPLEMENTADO",
                    Toast.LENGTH_LONG).show()
            startActivity(intent)
        })
        btn_pedido.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, CadastrarActivity::class.java)*//* enviar para tela de cadastro*//*
            Toast.makeText(this, "REDIRECIONANDO PARA PAGINA DE PEDIDOS",
                    Toast.LENGTH_LONG).show()
            startActivity(intent)
        })
        btn_comanda.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AcoesBtnActivity::class.java) *//*enviar para tela de cadastro*//*
            Toast.makeText(this, " NAO IMPLEMENTADO",
                    Toast.LENGTH_LONG).show()
            startActivity(intent)
        })
    }*/

        private var produtos = listOf<Produto>()
        override fun onResume() {
            super.onResume()
            produtos = ProdutoService.getProdutos()
            recycler_produtos?.adapter = ProdutoAdapter(produtos) { onClickProduto(it)
            }
        }

        fun onClickProduto(produto: Produto){
            Toast.makeText(this, "Clicou produto ${produto.nome}", Toast.LENGTH_LONG).show()
        }


        private fun configuraMenuLateral(){
            var toogle = ActionBarDrawerToggle(
                this,
                layout_menu_lateral,
                toolbar,
                R.string.nav_open,
                R.string.nav_close
            )
            layout_menu_lateral.addDrawerListener(toogle)
            toogle.syncState()

            nav_menu_lateral.setNavigationItemSelectedListener(this)
        }

        /*Inflando botoes do menu e colocando ações*/
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when(item.itemId){
                R.id.nav_comanda -> {
                    val builder = AlertDialog.Builder(this)
                    builder.setNeutralButton("OK", null)
                    builder.setTitle("Alerta")
                    val dialog = builder.create()
                    dialog.show()

                }

                R.id.nav_pedido -> {
                    Toast.makeText(this, "CLicou em Anotar Pedido", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, AnotarPedidoActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_config -> {
                    Toast.makeText(this, "CLicou em Configurar", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, ConfigurarActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_sair -> {
                    Toast.makeText(this, "CLicou em Sair", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

            }
            layout_menu_lateral.closeDrawer((GravityCompat.START))/*ao clicar em um item do menu, ele recolhe*/
            return true

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