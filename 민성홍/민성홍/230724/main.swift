//
//  main.swift
//  민성홍
//
//  Created by 민성홍 on 2023/07/24.
//
// 백준 10816 - 숫자 카드 2

import Foundation

let n: Int = Int(readLine()!)!
let nArray: [Int] = readLine()!.split(separator: " ").map { Int($0)! }
let m: Int = Int(readLine()!)!
let mArray: [Int] = readLine()!.split(separator: " ").map { Int($0)! }

var tempDic: [Int:Int] = [:]
var result: [Int] = []

for i in nArray {
    if tempDic.keys.contains(i) {
        tempDic[i]! += 1
    } else {
        tempDic[i] = 1
    }
}

for j in mArray {
    if tempDic.keys.contains(j) {
        result.append(tempDic[j]!)
    } else {
        result.append(0)
    }
}

print(result.map { String($0) }.joined(separator: " "))
