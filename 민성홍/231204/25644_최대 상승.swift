//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/12/04.
//  백준 25644: 최대 상승
//  메모리: 85428 KB
//  시간: 112 ms

let N = Int(readLine()!)!
let stockPrice: [Int] = readLine()!.split(separator: " ").map { Int($0)! }

var min = stockPrice[0]
var result = 0

for i in 1..<N {
    if stockPrice[i] < min {
        min = stockPrice[i]
    } else {
        let difference = stockPrice[i] - min
        if difference > result {
            result = difference
        }
    }
}

print(result)
