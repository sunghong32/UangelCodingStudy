//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/10/16.
//  백준 7490: 0 만들기
//  메모리: 79512 KB
//  시간: 112 ms

import Foundation

func zero(target: Int, n: Int, text: String) {
    if target == n {
        if stringCalculate(text) == 0 {
            print(text)
        }

        return
    }

    let next = target + 1

    zero(target: target + 1, n: n, text: text + " \(next)")
    zero(target: target + 1, n: n, text: text + "+\(next)")
    zero(target: target + 1, n: n, text: text + "-\(next)")
}

func stringCalculate(_ expression: String) -> Double? {
    let components = expression.replacingOccurrences(of: " ", with: "")

    var numbers: [Double] = []
    var operations: [Character] = []
    var numberBuffer = ""

    for character in components {
        if let _ = Double(String(character)) {
            numberBuffer.append(character)
        } else {
            if let number = Double(numberBuffer) {
                numbers.append(number)
                numberBuffer.removeAll()
            }

            operations.append(character)
        }
    }

    if let number = Double(numberBuffer) {
        numbers.append(number)
        numberBuffer.removeAll()
    }

    guard !numbers.isEmpty && (numbers.count - 1 == operations.count) else { return nil }

    var result = numbers[0]

    for i in 0..<operations.count {
        switch operations[i] {
        case "+":
            result += numbers[i + 1]
        case "-":
            result -= numbers[i + 1]
        default:
            return nil
        }
    }

    return result
}

func solve() {
    let testCase = Int(readLine()!)!

    for _ in 0..<testCase {
        let N = Int(readLine()!)!

        zero(target: 1, n: N, text: "1")
        print()
    }
}

solve()
