package pt.ipg.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

    val random = Random(System.currentTimeMillis())

    var pos11 = findViewById<TextView>(R.id.textView11)
    var pos12 = findViewById<TextView>(R.id.textView12)
    var pos13 = findViewById<TextView>(R.id.textView13)
    var pos14 = findViewById<TextView>(R.id.textView14)
    var pos15 = findViewById<TextView>(R.id.textView15)

    var pos21 = findViewById<TextView>(R.id.textView21)
    var pos22 = findViewById<TextView>(R.id.textView22)
    var pos23 = findViewById<TextView>(R.id.textView23)
    var pos24 = findViewById<TextView>(R.id.textView24)
    var pos25 = findViewById<TextView>(R.id.textView25)

    var pos31 = findViewById<TextView>(R.id.textView31)
    var pos32 = findViewById<TextView>(R.id.textView32)
    var pos33 = findViewById<TextView>(R.id.textView33)
    var pos34 = findViewById<TextView>(R.id.textView34)
    var pos35 = findViewById<TextView>(R.id.textView35)

    var pos41 = findViewById<TextView>(R.id.textView41)
    var pos42 = findViewById<TextView>(R.id.textView42)
    var pos43 = findViewById<TextView>(R.id.textView43)
    var pos44 = findViewById<TextView>(R.id.textView44)
    var pos45 = findViewById<TextView>(R.id.textView45)

    var pos51 = findViewById<TextView>(R.id.textView51)
    var pos52 = findViewById<TextView>(R.id.textView52)
    var pos53 = findViewById<TextView>(R.id.textView53)
    var pos54 = findViewById<TextView>(R.id.textView54)
    var pos55 = findViewById<TextView>(R.id.textView55)

    var pos61 = findViewById<TextView>(R.id.textView61)
    var pos62 = findViewById<TextView>(R.id.textView62)
    var pos63 = findViewById<TextView>(R.id.textView63)
    var pos64 = findViewById<TextView>(R.id.textView64)
    var pos65 = findViewById<TextView>(R.id.textView65)

    var word = findViewById<EditText>(R.id.editTextWord)

    var tentativas = 1

    var palavraAdivinhar = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonSubmit).setOnClickListener { submit() }
    }

    private fun novoJogo(){
        val index = random.nextInt(0, palavras.size)

        tentativas = 1

        clear()

        palavraAdivinhar = palavras.get(index)


    }

    private fun submit(){

        if(word.text.toString().length < 5 || word.text.toString().length > 5){
            word.error = "A palavra tem de ter 5 letras"
            word.requestFocus()
            return
        }
        if(!word.text.toString().isDigitsOnly() || word.text.toString().isBlank()){
            word.error = "É uma palavra seu analfabeto"
            word.requestFocus()
            return
        }

        when(tentativas){
            1 -> {
                pos11.text = word.text[0].toString()
                pos12.text = word.text[1].toString()
                pos13.text = word.text[2].toString()
                pos14.text = word.text[3].toString()
                pos15.text = word.text[4].toString()
                tentativas++
            }
            2 -> {
                pos21.text = word.text[0].toString()
                pos22.text = word.text[1].toString()
                pos23.text = word.text[2].toString()
                pos24.text = word.text[3].toString()
                pos25.text = word.text[4].toString()
                tentativas++
            }
            3 -> {
                pos31.text = word.text[0].toString()
                pos32.text = word.text[1].toString()
                pos33.text = word.text[2].toString()
                pos34.text = word.text[3].toString()
                pos35.text = word.text[4].toString()
                tentativas++
            }
            4 -> {
                pos41.text = word.text[0].toString()
                pos42.text = word.text[1].toString()
                pos43.text = word.text[2].toString()
                pos44.text = word.text[3].toString()
                pos45.text = word.text[4].toString()
                tentativas++
            }
            5 -> {
                pos51.text = word.text[0].toString()
                pos52.text = word.text[1].toString()
                pos53.text = word.text[2].toString()
                pos54.text = word.text[3].toString()
                pos55.text = word.text[4].toString()
                tentativas++
            }
            6 -> {
                pos61.text = word.text[0].toString()
                pos62.text = word.text[1].toString()
                pos63.text = word.text[2].toString()
                pos64.text = word.text[3].toString()
                pos65.text = word.text[4].toString()
                tentativas++
            }
        }
    }

    private fun clear(){
        pos11.text = " "
        pos12.text = " "
        pos13.text = " "
        pos14.text = " "
        pos15.text = " "

        pos21.text = " "
        pos22.text = " "
        pos23.text = " "
        pos24.text = " "
        pos25.text = " "

        pos31.text = " "
        pos32.text = " "
        pos33.text = " "
        pos34.text = " "
        pos35.text = " "

        pos41.text = " "
        pos42.text = " "
        pos43.text = " "
        pos44.text = " "
        pos45.text = " "

        pos51.text = " "
        pos52.text = " "
        pos53.text = " "
        pos54.text = " "
        pos55.text = " "

        pos61.text = " "
        pos62.text = " "
        pos63.text = " "
        pos64.text = " "
        pos65.text = " "

        word.text.clear()
    }
}