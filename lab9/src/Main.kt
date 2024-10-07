import kotlin.random.Random
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    // 1. Генератор случайных чисел

    println("Генератор случайных чисел:")
    for (i in 1..10) {
        println(Random.nextInt(1, 101))
    }

    // 2. Строковый анализатор
    println("\nСтроковый анализатор:")
    print("Введите строку: ")
    val inputString0 = readLine() ?: ""
    val vowels = "aeiouAEIOU"
    var vowelCount = 0
    var consonantCount = 0

    for (char in inputString0) {
        if (char in vowels) {
            vowelCount++
        } else if (char.isLetter()) {
            consonantCount++
        }
    }

    println("Количество гласных: $vowelCount")
    println("Количество согласных: $consonantCount")

    // 3. Конвертер валют
    println("\nКонвертер валют:")
    print("Введите сумму в долларах: ")
    val dollars = readLine()?.toDoubleOrNull() ?: 0.0


    val euroRate = 0.91 // Курс доллара к евро
    val euros = dollars * euroRate

    println("$dollars долларов = $euros евро")

    // 4. Проверка на анаграмму
    println("\nПроверка на анаграмму:")
    print("Введите первую строку: ")
    val str1 = readLine() ?: ""
    print("Введите вторую строку: ")
    val str2 = readLine() ?: ""

    if (isAnagram(str1, str2)) {
        println("Строки являются анаграммами")
    } else {
        println("Строки не являются анаграммами")
    }

    // 5. Нахождение простых чисел
    println("\nНахождение простых чисел:")
    print("Введите число N: ")
    val n = readLine()?.toIntOrNull() ?: 0

    if (n > 1) {
        println("Простые числа до $n:")
        for (i in 2..n) {
            if (isPrime(i)) {
                print("$i ")
            }
        }
    } else {
        println("Введите число больше 1")
    }

    // 6. Сортировка строк
    println("\nСортировка строк:")
    print("Введите строки, разделенные пробелами: ")
    val inputStrings = readLine()?.split(" ") ?: emptyList()

    val sortedStrings = inputStrings.sorted()
    println("Отсортированные строки: ${sortedStrings.joinToString(" ")}")

    // 7. Изменение регистра
    println("введите строку для изменения регистра:")
    val caseStr = scanner.nextLine()
    println("измененный регистр: ${toggleCase(caseStr)}")

    // 8. Игра "Угадай число"
    println("\nИгра \"Угадай число\":")
    val randomNumber = Random.nextInt(1, 101)
    var guessesLeft = 10
    println("Добро пожаловать в игру \"Угадай число\"!")
    println("Я загадал число от 1 до 100. У вас есть 10 попыток.")

    while (guessesLeft > 0) {
        print("Введите ваше число: ")
        val guess = readLine()?.toIntOrNull() ?: 0

        if (guess == randomNumber) {
            println("Поздравляю! Вы угадали число $randomNumber за ${10 - guessesLeft} попыток!")
            break
        } else if (guess < randomNumber) {
            println("Загаданное число больше. Попробуйте еще раз.")
        } else {
            println("Загаданное число меньше. Попробуйте еще раз.")
        }
        guessesLeft--
    }

    if (guessesLeft == 0) {
        println("У вас закончились попытки! Загаданное число было $randomNumber.")
    }

    // 9. Генератор паролей
    println("\nГенератор паролей:")
    print("Введите длину пароля: ")
    val passwordLength = readLine()?.toIntOrNull() ?: 0

    if (passwordLength > 0) {
        println("Сгенерированный пароль: ${generatePassword(passwordLength)}")
    } else {
        println("Введите положительное целое число.")
    }

    // 10. Самое длинное слово
    println("\nСамое длинное слово:")
    print("Введите строку: ")
    val inputString = readLine() ?: ""

    val longestWord = longestWord(inputString)
    println("Самое длинное слово: $longestWord")
}

fun isAnagram(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) {
        return false
    }

    val sortedStr1 = str1.lowercase().toCharArray().sortedArray()
    val sortedStr2 = str2.lowercase().toCharArray().sortedArray()

    return sortedStr1.contentEquals(sortedStr2)
}

fun isPrime(num: Int): Boolean {
    if (num <= 1) {
        return false
    }
    for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}

fun toggleCase(str: String): String {
    return str.map {
        if (it.isUpperCase()) it.lowercaseChar() else it.uppercaseChar()
    }.joinToString("")
}

fun generatePassword(length: Int): String {
    val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+"
    val password = StringBuilder()

    for (i in 1..length) {
        val randomIndex = Random.nextInt(0, characters.length)
        password.append(characters[randomIndex])
    }

    return password.toString()
}

fun longestWord(str: String): String {
    val words = str.split("""\s+|[,.?!;:]""".toRegex()).toTypedArray()
    var longestWord = words[0]
    for (word in words) {
        if (word.length > longestWord.length) {
            longestWord = word
        }
    }
    return longestWord
}


