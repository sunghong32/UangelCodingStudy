//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/08/04.
// 백준 2447: 별 찍기 - 10
// 메모리: 76980KB
// 시간: 536ms

let N: Int = Int(String(readLine()!))!
var star: String = ""

func check(n: Int, i: Int, j: Int) {
    if (i / n) % 3 == 1 && (j / n) % 3 == 1 {
        star += " "
    }else {
        if n / 3 == 0 {
            star += "*"
        }else {
            check(n: n / 3, i: i, j: j)
        }
    }
}

for i in 0..<N {
    for j in 0..<N {
        check(n: N, i: i, j: j)
    }

    star += "\n"
}

print(star)
