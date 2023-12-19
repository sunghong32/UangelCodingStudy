//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 12/18/23.
//  백준 1918: 후위 표기식
//  메모리: 79516 KB
//  시간: 12 ms

import Foundation

class Stack<T> {
    private var array = [T]()

    var isEmpty: Bool {
        return array.isEmpty
    }

    var top: T? {
        return array.last
    }

    func push(_ element: T) {
        array.append(element)
    }

    func pop() -> T? {
        return array.popLast()
    }
}

func precedence(_ op: String) -> Int {
    switch op {
    case "+", "-":
        return 1
    case "*", "/":
        return 2
    default:
        return 0
    }
}

func toPostfix(_ infix: String) -> String {
    var outputQueue = ""
    let operatorStack = Stack<String>()

    let operators = Set(["+", "-", "*", "/", "(" , ")"])

    let expression = infix.map { String($0) }

    for token in expression {
        if operators.contains(token) {
            if token != "(" && token != ")" {
                while let topOperator = operatorStack.top,
                      operators.contains(topOperator),
                      precedence(token) <= precedence(topOperator) {
                    outputQueue += operatorStack.pop()!
                }
            }
            if token == ")" {
                while let topOperator = operatorStack.top, topOperator != "(" {
                    outputQueue += operatorStack.pop()!
                }
                _ = operatorStack.pop()
            } else {
                operatorStack.push(token)
            }
        } else {
            outputQueue += token
        }
    }

    while let topOperator = operatorStack.top, operators.contains(topOperator) {
        outputQueue += operatorStack.pop()!
    }

    return outputQueue
}

if let operation = readLine() {
    let postfix = toPostfix(operation)
    print(postfix)
}
