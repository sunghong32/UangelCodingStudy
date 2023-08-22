//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/08/22.
//  백준 15649: N과 M (1)
//  메모리: 79512KB
//  시간: 112ms

import Foundation

let NM = readLine()!.split(separator: " ").map { Int(String($0))! }
let N = NM[0]
let M = NM[1]

var array: [Int] = []

recur()

func recur() {
    if array.count == M {
        print(array.map{ String($0) }.joined(separator:" "))
        return
    }

    for i in 1...N {
        if !array.contains(i) {
            array.append(i)
            recur()
            array.removeLast()
        }
    }
}
