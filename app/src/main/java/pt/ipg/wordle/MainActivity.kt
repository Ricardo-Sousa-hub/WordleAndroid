package pt.ipg.wordle

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.text.isDigitsOnly
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val palavras: List<String> = listOf("sagaz", "âmago", "negro",
        "êxito",
        "mexer",
        "termo",
        "senso",
        "nobre",
        "algoz",
        "afeto",
        "plena",
        "ética",
        "mútua",
        "tênue",
        "sutil",
        "vigor",
        "aquém",
        "porém",
        "audaz",
        "fazer",
        "sanar",
        "seção",
        "inato",
        "assim",
        "cerne",
        "ideia",
        "fosse",
        "desde",
        "poder",
        "moral",
        "torpe",
        "muito",
        "honra",
        "justo",
        "fútil",
        "gozar",
        "anexo",
        "razão",
        "quiçá",
        "etnia",

        "sobre",

        "ícone",

        "tange",

        "sonho",

        "égide",

        "lapso",

        "mútuo",

        "expor",

        "haver",

        "amigo",

        "hábil",

        "casal",

        "tempo",

        "seara",

        "pesar",

        "posse",

        "ávido",

        "porra",

        "então",

        "boçal",

        "dengo",

        "genro",

        "coser",

        "ardil",

        "corja",

        "causa",

        "prole",

        "pária",

        "detém",

        "dizer",

        "tenaz",

        "dever",

        "digno",

        "saber",

        "crivo",

        "óbice",

        "ápice",

        "ânsia",

        "graça",

        "ânimo",

        "ceder",

        "brado",

        "orgia",

        "gleba",

        "comum",

        "assaz",

        "atroz",

        "culto",

        "sendo",

        "temor",

        "mundo",

        "pauta",

        "censo",

        "fugaz",

        "denso",

        "valha",

        "cozer",

        "ainda",

        "neném",

        "vício",

        "forte",

        "estar",

        "revés",

        "vulgo",

        "pudor",

        "regra",

        "dogma",

        "louco",

        "criar",

        "banal",

        "impor",

        "pífio",

        "tenro",

        "desse",

        "apraz",

        "round",

        "jeito",

        "saúde",

        "ordem",

        "atrás",

        "pedir",

        "reaça",

        "mercê",

        "clava",

        "usura",

        "viril",

        "juízo",

        "sábio",

        "prosa",

        "servo",

        "manso",

        "ontem",

        "feliz",

        "presa",

        "coisa",

        "homem",

        "falar",

        "cunho",

        "forma",

        "devir",

        "fluir",

        "afago",

        "ébrio",

        "meiga",

        "xibiu",

        "platô",

        "sério",

        "vendo",

        "mesmo",

        "guisa",

        "limbo",

        "pleno",

        "visar",

        "mágoa",

        "temer",

        "herói",

        "cisma",

        "acaso",

        "bruma",

        "puder",

        "lugar",

        "valor",

        "êxodo",

        "óbvio",

        "gerar",

        "afins",

        "ímpio",

        "obter",

        "matiz",

        "certo",

        "crise",

        "senil",

        "praxe",

        "posso",

        "havia",

        "vênia",

        "fluxo",

        "enfim",

        "ritmo",

        "tédio",

        "álibi",

        "todos",

        "tomar",

        "garbo",

        "abrir",

        "união",

        "reter",

        "pulha",

        "parvo",

        "valia",

        "visão",

        "vital",

        "grato",

        "favor",

        "fácil",

        "bravo",

        "vivaz",

        "falso",

        "laico",

        "parco",

        "prumo",

        "gênio",

        "ameno",

        "olhar",

        "possa",

        "reles",

        "óbito",

        "burro",

        "levar",

        "prime",

        "tesão",

        "casta",

        "tecer",

        "legal",

        "selar",

        "anelo",

        "fator",

        "ranço",

        "citar",

        "rogar",

        "farsa",

        "façam",

        "noção",

        "adiar",

        "morte",

        "achar",

        "coeso",

        "cabal",

        "cisão",

        "épico",

        "sábia",

        "nicho",

        "falta",

        "fardo",

        "ouvir",

        "imune",

        "força",

        "sinto",

        "ativo",

        "gente",

        "viver",

        "exato",

        "noite",

        "haste",

        "brega",

        "amplo",

        "lavra",

        "sulco",

        "passo",

        "sonso",

        "dúbio",

        "cesta",

        "labor",

        "tendo",

        "gesto",

        "revel",

        "leigo",

        "sesta",

        "único",

        "deter",

        "vemos",

        "árduo",

        "atuar",

        "calma",

        "feixe",

        "vadia",

        "rever",

        "ótica",

        "humor",

        "ciúme",

        "tende",

        "igual",

        "pobre",

        "hiato",

        "sonsa",

        "toada",

        "ponto",

        "débil",

        "ideal",

        "velho",

        "outro",

        "vácuo",

        "claro",

        "linda",

        "carma",

        "ambos",

        "terno",

        "remir",

        "fusão",

        "varão",

        "cauda",

        "probo",

        "ajuda",

        "leito",

        "senão",

        "advém",

        "doido",

        "marco",

        "fonte",

        "jovem",

        "horda",

        "inata",

        "capaz",

        "xeque",

        "relva",

        "tenra",

        "algum",

        "ficar",

        "caçar",

        "velar",

        "apoio",

        "terra",

        "série",

        "anuir",

        "farão",

        "rigor",

        "vimos",

        "dorso",

        "verso",

        "líder",

        "vazio",

        "tanto",

        "entre",

        "botar",

        "coçar",

        "frase",

        "cruel",

        "massa",

        "prece",

        "vírus",

        "pouco",

        "moção",

        "ambas",

        "morar",

        "signo",

        "coesa",

        "peste",

        "sente",

        "casto",

        "fauna",

        "covil",

        "preso",

        "credo",

        "minha",

        "feito",

        "faina",

        "raiva",

        "furor",

        "lazer",

        "dócil",

        "ciclo",

        "ímpar",

        "torço",

        "vetor",

        "flora",

        "maior",

        "corno",

        "chata",

        "papel",

        "árido",

        "brisa",

        "aceso",

        "beata",

        "trama",

        "vulto",

        "houve",

        "pegar",

        "breve",

        "manha",

        "adeus",

        "liame",

        "birra",

        "setor",

        "vasto",

        "salvo",

        "blasé",

        "senda",

        "seita",

        "banzo",

        "ardor",

        "nossa",

        "morro",

        "livro",

        "pecha",

        "átomo",

        "visse",

        "prado",

        "reger",

        "peixe",

        "antro",

        "meses",

        "avaro",

        "segue",

        "comer",

        "prono",

        "plano",

        "ocaso",

        "saiba",

        "rezar",

        "chuva",

        "sorte",

        "anciã",

        "áureo",

        "saída",

        "ótimo",

        "aliás",

        "pajem",

        "nunca",

        "foder",

        "junto",

        "acima",

        "chulo",

        "mudar",

        "carro",

        "fitar",

        "opção",

        "serão",

        "sinal",

        "jazia",

        "fruir",

        "parar",

        "séria",

        "treta",

        "fugir",

        "puxar",

        "bando",

        "nação",

        "motim",

        "gerir",

        "prazo",

        "andar",

        "grupo",

        "tosco",

        "leite",

        "norma",

        "alude",

        "época",

        "sinhá",

        "brava",

        "lenda",

        "rapaz",

        "tenso",

        "parte",

        "exame",

        "avião",

        "ídolo",

        "arcar",

        "campo",

        "tirar",

        "psico",

        "reino",

        "venal",

        "soldo",

        "malta",

        "praga",

        "quota",

        "virão",

        "vilão",

        "sumir",

        "anais",

        "aonde",

        "exijo",

        "corpo",

        "logro",

        "agora",

        "pompa",

        "traga",

        "preto",

        "voraz",

        "fixar",

        "antes",

        "índio",

        "quase",

        "cheio",

        "risco",

        "praia",

        "certa",

        "filho",

        "turva",

        "nódoa",

        "solto",

        "cópia",

        "oásis",

        "turba",

        "alado",

        "apego",

        "texto",

        "caixa",

        "messe",

        "estão",

        "doído",

        "grave",

        "prova",

        "parva",

        "acesa",

        "perda",

        "verve",

        "nível",

        "apelo",

        "ligar",

        "átrio",

        "pardo",

        "tocar",

        "trupe",

        "fenda",

        "lindo",

        "dessa",

        "viria",

        "sabia",

        "livre",

        "retém",

        "conta",

        "coito",

        "alçar",

        "verbo",

        "opaco",

        "navio",

        "áurea",

        "ficha",

        "fraco",

        "afora",

        "ético",

        "astro",

        "faixa",

        "elite",

        "parca",

        "supra",

        "glosa",

        "jirau",

        "autor",

        "verba",

        "cioso",

        "lidar",

        "mente",

        "oxalá",

        "tinha",

        "firme",

        "festa",

        "grata",

        "fatos",

        "magia",

        "fatal",

        "bater",

        "calda",

        "reses",

        "cousa",

        "privê",

        "junco",

        "pique",

        "irmão",

        "deixa",

        "pagão",

        "molho",

        "salve",

        "douto",

        "macio",

        "abriu",

        "manhã",

        "torso",

        "turvo",

        "supor",

        "light",

        "atual",

        "bicho",

        "posto",

        "ígneo",

        "asilo",

        "órfão",

        "extra",

        "rouca",

        "caber",

        "judeu",

        "curso",

        "sarça",

        "sexta",

        "vezes",

        "locus",

        "besta",

        "ruína",

        "pisar",

        "desta",

        "zelar",

        "rádio",

        "vídeo",

        "longe",

        "abuso",

        "porta",

        "cânon",

        "paira",

        "combo",

        "ereto",

        "finda",

        "bioma",

        "culpa",

        "vinha",

        "vosso",

        "agudo",

        "feudo",

        "menos",

        "baixo",

        "facto",

        "tetra",

        "drops",

        "urgia",

        "bônus",

        "advir",

        "cútis",

        "surja",

        "estio",

        "meigo",

        "traço",

        "super",

        "sítio",

        "autos",

        "tento",

        "gosto",

        "rumor",

        "facho",

        "suave",

        "calão",

        "cocho",

        "amena",

        "pilar",

        "museu",

        "nosso",

        "clean",

        "turma",

        "lasso",

        "geral",

        "acolá",

        "chama",

        "ações",

        "optar",

        "pífia",

        "medir",

        "louça",

        "boato",

        "mosto",

        "pódio",

        "lápis",

        "local",

        "penta",

        "hobby",

        "rubro",

        "crime",

        "letal",

        "pacto",

        "folga",

        "ponha",

        "cacho",

        "refém",

        "drama",

        "cover",

        "brabo",

        "aroma",

        "hoste",

        "vigia",

        "poema",

        "vetar",

        "fazia",

        "pasmo",

        "feroz",

        "mesma",

        "móvel",

        "açude",

        "rival",

        "finjo",

        "troça",

        "monte",

        "axila",

        "peito",

        "golpe",

        "aluno",

        "metiê",

        "ávida",

        "ecoar",

        "páreo",

        "coral",

        "júlia",

        "riste",

        "teste",

        "fórum",

        "lesse",

        "lição",

        "daqui",

        "plebe",

        "súcia",

        "forem",

        "monge",

        "clima",

        "chato",

        "carta",

        "poeta",

        "ébano",

        "escol",

        "cetro",

        "macro",

        "swing",

        "piada",

        "passa",

        "falha",

        "sarau",

        "viram",

        "venha",

        "ateia",

        "verde",

        "tacha",

        "briga",

        "conto",

        "calmo",

        "cargo",

        "farta",

        "légua",

        "átimo",

        "fruto",

        "roupa",

        "busca",

        "perco",

        "berro",

        "tarde",

        "plaga",

        "idoso",

        "broxa",

        "plumo",

        "aviso",

        "artur",

        "tribo",

        "chefe",

        "vento",

        "virar",

        "corso",

        "grama",

        "arado",

        "civil",

        "surto",

        "assar",

        "estro",

        "seixo",

        "bruta",

        "recém",

        "catre",

        "traje",

        "ornar",

        "saldo",

        "nuvem",

        "beijo",

        "deste",

        "ímpia",

        "fosso",

        "troca",

        "pedra",

        "deram",

        "trato",

        "vedar",

        "arfar",

        "depor",

        "tição",

        "gíria",

        "porte",

        "irado",

        "úteis",

        "mangá",

        "casar",

        "grota",

        "canso",

        "âmbar",

        "manga",

        "silvo",

        "única",

        "cifra",

        "pasma",

        "bença",

        "gabar",

        "bazar",

        "amado",

        "sósia",

        "tutor",

        "magna",

        "vazão",

        "régio",

        "rural",

        "tiver",

        "pavor",

        "laudo",

        "bruto",

        "perto",

        "segar",

        "itens",

        "renda",

        "bucho",

        "mídia",

        "troco",

        "tchau",

        "amiga",

        "nesse",

        "jejum",

        "vagar",

        "minar",

        "molde",

        "odiar",

        "inter",

        "viado",

        "clero",

        "lesto",

        "vadio",

        "feita",

        "fossa",

        "órgão",

        "meche",

        "sótão",

        "areia",

        "pomar",

        "aviar",

        "negar",

        "cenho",

        "cinto",

        "largo",

        "paiol",

        "lesão",

        "ileso",

        "canto",

        "rocha",

        "pinho",

        "horto",

        "visto",

        "pugna",

        "ruído",

        "bolsa",

        "proto",

        "podar",

        "invés",

        "ufano",

        "marca",

        "urdir",

        "guria",

        "densa",

        "vista",

        "morfo",

        "cível",

        "dúbia",

        "jogar",

        "close",

        "frota",

        "vasta",

        "mocho",

        "penso",

        "mamãe",

        "xucro",

        "bunda",

        "bulir",

        "culta",

        "piche",

        "úmido",

        "chula",

        "peita",

        "amada",

        "cheia",

        "úbere",

        "linha",

        "esgar",

        "stand",

        "canil",

        "resto",

        "varoa",

        "apear",

        "misto",

        "demão",

        "fazes",

        "manto",

        "natal",

        "monta",

        "narco",

        "fundo",

        "findo",

        "campa",

        "barão",

        "gemer",

        "ágape",

        "nessa",

        "tenha",

        "chaga",

        "jazer",

        "símio",

        "retro",

        "álbum",

        "mover",

        "cerca",

        "preço",

        "ardis",

        "venho",

        "folia",

        "cosmo",

        "pólis",

        "santo",

        "lábia",

        "velha",

        "volta",

        "punha",

        "seiva",

        "ferpa",

        "álamo",

        "matar",

        "verão",

        "sabor",

        "banto",

        "letra",

        "porca",

        "sigla",

        "calça",

        "rente",

        "ceita",

        "louro",

        "firma",

        "barro",

        "nesta",

        "salva",

        "etapa",

        "trago",

        "áudio",

        "arroz",

        "troço",

        "axial",

        "redor",

        "tumba",

        "limpo",

        "torna",

        "míope",

        "final",

        "coevo",

        "bolso",

        "solta",

        "logos",

        "enjoo",

        "lousa",

        "coroa",

        "ousar",

        "lutar",

        "queda",

        "baixa",

        "fugiu",

        "sinta",

        "corar",

        "zumbi",

        "mimar",

        "farol",

        "obtém",

        "veloz",

        "neste",

        "cacto",

        "folha",

        "nácar",

        "burra",

        "reler",

        "dança",

        "fátuo",

        "longo",

        "penca",

        "vazia",

        "vário",

        "forro",

        "macho",

        "quite",

        "justa",

        "mania",

        "farto",

        "bedel",

        "sugar",

        "puído",

        "salmo",

        "repor",

        "lucro",

        "staff",

        "ultra",

        "refil",

        "calor",

        "chave",

        "gueto",

        "subir",

        "viger",

        "passe",

        "custo",

        "sexto",

        "urgir",

        "logia",

        "sadio",

        "mimos",

        "todas",

        "harém",

        "hífen",

        "valer",

        "versa",

        "calvo",

        "usual",

        "lento",

        "sócio",

        "mouro",

        "cardo",

        "merda",

        "rédea",

        "árdua")

    private val random = Random(System.currentTimeMillis())

    private var pos11:TextView? = null
    private var pos12:TextView? = null
    private var pos13:TextView? = null
    private var pos14:TextView? = null
    private var pos15:TextView? = null

    private var pos21:TextView? = null
    private var pos22:TextView? = null
    private var pos23:TextView? = null
    private var pos24:TextView? = null
    private var pos25:TextView? = null

    private var pos31:TextView? = null
    private var pos32:TextView? = null
    private var pos33:TextView? = null
    private var pos34:TextView? = null
    private var pos35:TextView? = null

    private var pos41:TextView? = null
    private var pos42:TextView? = null
    private var pos43:TextView? = null
    private var pos44:TextView? = null
    private var pos45:TextView? = null

    private var pos51:TextView? = null
    private var pos52:TextView? = null
    private var pos53:TextView? = null
    private var pos54:TextView? = null
    private var pos55:TextView? = null

    private var pos61:TextView? = null
    private var pos62:TextView? = null
    private var pos63:TextView? = null
    private var pos64:TextView? = null
    private var pos65:TextView? = null

    private var posA1:TextView? = null
    private var posA2:TextView? = null
    private var posA3:TextView? = null
    private var posA4:TextView? = null
    private var posA5:TextView? = null

    private var solve:TextView? = null

    private var word:EditText? = null

    private var tentativas = 1

    private var palavraAdivinhar = ""

    private var palavra = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pos11 = findViewById<TextView>(R.id.textView11)
        pos12 = findViewById<TextView>(R.id.textView12)
        pos13 = findViewById<TextView>(R.id.textView13)
        pos14 = findViewById<TextView>(R.id.textView14)
        pos15 = findViewById<TextView>(R.id.textView15)

        pos21 = findViewById<TextView>(R.id.textView21)
        pos22 = findViewById<TextView>(R.id.textView22)
        pos23 = findViewById<TextView>(R.id.textView23)
        pos24 = findViewById<TextView>(R.id.textView24)
        pos25 = findViewById<TextView>(R.id.textView25)

        pos31 = findViewById<TextView>(R.id.textView31)
        pos32 = findViewById<TextView>(R.id.textView32)
        pos33 = findViewById<TextView>(R.id.textView33)
        pos34 = findViewById<TextView>(R.id.textView34)
        pos35 = findViewById<TextView>(R.id.textView35)

        pos41 = findViewById<TextView>(R.id.textView41)
        pos42 = findViewById<TextView>(R.id.textView42)
        pos43 = findViewById<TextView>(R.id.textView43)
        pos44 = findViewById<TextView>(R.id.textView44)
        pos45 = findViewById<TextView>(R.id.textView45)

        pos51 = findViewById<TextView>(R.id.textView51)
        pos52 = findViewById<TextView>(R.id.textView52)
        pos53 = findViewById<TextView>(R.id.textView53)
        pos54 = findViewById<TextView>(R.id.textView54)
        pos55 = findViewById<TextView>(R.id.textView55)

        pos61 = findViewById<TextView>(R.id.textView61)
        pos62 = findViewById<TextView>(R.id.textView62)
        pos63 = findViewById<TextView>(R.id.textView63)
        pos64 = findViewById<TextView>(R.id.textView64)
        pos65 = findViewById<TextView>(R.id.textView65)

        word = findViewById<EditText>(R.id.editTextWord)

        solve = findViewById<TextView>(R.id.textViewSolve)

        novoJogo()

        findViewById<Button>(R.id.buttonSubmit).setOnClickListener { submit() }
    }

    private fun novoJogo(){
        val index = random.nextInt(0, palavras.size)

        tentativas = 1

        clear()

        palavraAdivinhar = palavras.get(index)
        solve!!.text = palavraAdivinhar
        palavraAdivinhar += " "

    }

    private fun submit(){

        if(tentativas <= 6) {
            if (word!!.text.toString().isDigitsOnly() || word!!.text.toString().isBlank()) {
                word!!.error = "É uma palavra seu analfabeto"
                word!!.requestFocus()
                return
            }

            if (word!!.text.toString().length < 5 || word!!.text.toString().length > 5) {
                word!!.error = "A palavra tem de ter 5 letras"
                word!!.requestFocus()
                return
            }

            palavra = word!!.text.toString()+" "

            when (tentativas) {
                1 -> {
                    pos11!!.text = palavra[0].toString()
                    pos12!!.text = palavra[1].toString()
                    pos13!!.text = palavra[2].toString()
                    pos14!!.text = palavra[3].toString()
                    pos15!!.text = palavra[4].toString()
                    posA(pos11!!, pos12!!, pos13!!, pos14!!, pos15!!)
                    verificarInput()
                    tentativas++
                }
                2 -> {
                    pos21!!.text = palavra[0].toString()
                    pos22!!.text = palavra[1].toString()
                    pos23!!.text = palavra[2].toString()
                    pos24!!.text = palavra[3].toString()
                    pos25!!.text = palavra[4].toString()
                    posA(pos21!!, pos22!!, pos23!!, pos24!!, pos25!!)
                    verificarInput()
                    tentativas++
                }
                3 -> {
                    pos31!!.text = palavra[0].toString()
                    pos32!!.text = palavra[1].toString()
                    pos33!!.text = palavra[2].toString()
                    pos34!!.text = palavra[3].toString()
                    pos35!!.text = palavra[4].toString()
                    posA(pos31!!, pos32!!, pos33!!, pos34!!, pos35!!)
                    verificarInput()
                    tentativas++
                }
                4 -> {
                    pos41!!.text = palavra[0].toString()
                    pos42!!.text = palavra[1].toString()
                    pos43!!.text = palavra[2].toString()
                    pos44!!.text = palavra[3].toString()
                    pos45!!.text = palavra[4].toString()
                    posA(pos41!!, pos42!!, pos43!!, pos44!!, pos45!!)
                    verificarInput()
                    tentativas++
                }
                5 -> {
                    pos51!!.text = palavra[0].toString()
                    pos52!!.text = palavra[1].toString()
                    pos53!!.text = palavra[2].toString()
                    pos54!!.text = palavra[3].toString()
                    pos55!!.text = palavra[4].toString()
                    posA(pos51!!, pos52!!, pos53!!, pos54!!, pos55!!)
                    verificarInput()
                    tentativas++
                }
                6 -> {
                    pos61!!.text = palavra[0].toString()
                    pos62!!.text = palavra[1].toString()
                    pos63!!.text = palavra[2].toString()
                    pos64!!.text = palavra[3].toString()
                    pos65!!.text = palavra[4].toString()
                    posA(pos61!!, pos62!!, pos63!!, pos64!!, pos65!!)
                    verificarInput()
                    tentativas++
                    endGame()
                }
            }
        }

    }

    private fun endGame(){
        val dialogoAlerta = AlertDialog.Builder(this)
        dialogoAlerta.setTitle("Jogar Novamente")
        dialogoAlerta.setMessage("Quer jogar novamente?")
        dialogoAlerta.setCancelable(false) //Isto diz que a pessoa pode sair do dialogo sem responder ou não
        dialogoAlerta.setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener{ dialog, wich -> novoJogo()})
        dialogoAlerta.setNegativeButton(android.R.string.cancel, DialogInterface.OnClickListener{ dialog, wich -> finish()})

        dialogoAlerta.show()
    }

    private fun verificarInput(){
        for(i in 0..5){
            for(y in 0..5){
                if(palavraAdivinhar[y] == palavra[i] && i != y){
                    when(i){
                        0 -> posA1!!.setTextColor(Color.parseColor("#ffff00"))
                        1 -> posA2!!.setTextColor(Color.parseColor("#ffff00"))
                        2 -> posA3!!.setTextColor(Color.parseColor("#ffff00"))
                        3 -> posA4!!.setTextColor(Color.parseColor("#ffff00"))
                        4 -> posA5!!.setTextColor(Color.parseColor("#ffff00"))
                    }
                }
            }
        }

        for(i in 0..5){ //Quando coloco 5, ele diz indexOutOfRange
            if(palavraAdivinhar[i] == palavra[i]){
                when(i){
                    0 -> posA1!!.setTextColor(Color.parseColor("#7CFC00"))
                    1 -> posA2!!.setTextColor(Color.parseColor("#7CFC00"))
                    2 -> posA3!!.setTextColor(Color.parseColor("#7CFC00"))
                    3 -> posA4!!.setTextColor(Color.parseColor("#7CFC00"))
                    4 -> posA5!!.setTextColor(Color.parseColor("#7CFC00"))
                }
            }
        }
    }

    private fun posA(posX1:TextView, posX2:TextView, posX3:TextView, posX4:TextView, posX5:TextView){
        posA1 = posX1
        posA2 = posX2
        posA3 = posX3
        posA4 = posX4
        posA5 = posX5
    }

    private fun clear(){
        pos11!!.text = "A"
        pos12!!.text = "A"
        pos13!!.text = "A"
        pos14!!.text = "A"
        pos15!!.text = "A"

        pos21!!.text = "A"
        pos22!!.text = "A"
        pos23!!.text = "A"
        pos24!!.text = "A"
        pos25!!.text = "A"

        pos31!!.text = "A"
        pos32!!.text = "A"
        pos33!!.text = "A"
        pos34!!.text = "A"
        pos35!!.text = "A"

        pos41!!.text = "A"
        pos42!!.text = "A"
        pos43!!.text = "A"
        pos44!!.text = "A"
        pos45!!.text = "A"

        pos51!!.text = "A"
        pos52!!.text = "A"
        pos53!!.text = "A"
        pos54!!.text = "A"
        pos55!!.text = "A"

        pos61!!.text = "A"
        pos62!!.text = "A"
        pos63!!.text = "A"
        pos64!!.text = "A"
        pos65!!.text = "A"

        word!!.text.clear()
    }
}